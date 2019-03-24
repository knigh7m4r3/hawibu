import {Component, OnDestroy, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {TypeaheadMatch} from 'ngx-bootstrap';
import {Subscription} from 'rxjs';
import {Artikel} from '../model/Artikel';
import {Bon} from '../model/Bon';
import {Geschaeft} from '../model/Geschaeft';
import {Kategorie} from '../model/Kategorie';
import {Posten} from '../model/Posten';
import {ArticleBonService} from '../services/article-bon.service';
import {ArtikelService} from '../services/artikel.service';
import {BonService} from '../services/bon.service';
import {GeschaeftService} from '../services/geschaeft.service';
import {KategorieService} from '../services/kategorie.service';
import {MonatService} from '../services/monat.service';
import {PostenService} from '../services/posten.service';

@Component({
  selector: 'app-bon',
  templateUrl: './bon.component.html',
  styleUrls: ['./bon.component.css']
})
export class BonComponent implements OnInit, OnDestroy {
  monate: String[] = [
    'Januar ',
    'Februar ',
    'März ',
    'April ',
    'Mai ',
    'Juni ',
    'Juli ',
    'August ',
    'September ',
    'Oktober ',
    'November ',
    'Dezember '];

  isLoading: number = 0;
  maxSubscriptions: number = 0;
  showAddArticle: boolean = false;

  geschaefte: Geschaeft[] = [];
  selectedGeschaeft: Geschaeft;

  selectedPreis: number;
  selectedMenge: number;

  posten: Posten[] = [];

  dateToday: string;
  selectedDate: Date;

  artikel: Artikel[] = [];
  selectedArtikel: Artikel;
  selectedArtikelName: string;

  kategorien: Kategorie[] = [];

  currentBon: Bon;

  currentGesamt: number = 0;

  subscription: Subscription;

  constructor(private articleBonService: ArticleBonService, private geschaeftService: GeschaeftService, private artikelService: ArtikelService,
              private kategorieService: KategorieService, private monatService: MonatService, private bonService: BonService,
              private postenService: PostenService, private router: Router) {
  }

  ngOnInit() {
    this.subscription = this.articleBonService.emitter.subscribe(data => {
      this.showAddArticle = data;
      this.loadArtikel();
      this.loadKategorie();
    });
    this.geschaeftService.getAllGeschaefte().subscribe(data => {
      this.geschaefte = data;
      ++this.isLoading;
    });
    this.loadArtikel();
    this.loadKategorie();

    const date = new Date();
    const month = String(date.getMonth() + 1).padStart(2, '0');
    const day = String(date.getDate()).padStart(2, '0');
    this.dateToday = date.getFullYear() + '-' + month + '-' + day;
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }

  loadArtikel(): void {
    this.artikel = [];
    this.artikelService.getAllArtikel().subscribe(data => {
      this.artikel = data;
      ++this.isLoading;
    });
  }

  loadKategorie(): void {
    this.kategorien = [];
    this.kategorieService.getAllKategorie().subscribe(data => {
      this.kategorien = data;
      ++this.isLoading;
    });
  }

  removePosten(post: Posten): void {
    this.currentGesamt -= post.menge * post.preis;

    const index = this.posten.indexOf(post, 0);
    if (index > -1) {
      this.posten.splice(index, 1);
    }

  }

  createPosten(): void {
    if (!this.currentBon) {
      this.createCurrentBon();
    }

    let post: Posten = new Posten();
    post.preis = this.selectedPreis;
    post.menge = this.selectedMenge;
    post.artikel = this.selectedArtikel;
    post.bon = this.currentBon;

    this.posten.push(post);
    this.currentGesamt += this.selectedMenge * this.selectedPreis;

  }

  createCurrentBon(): void {
    let bon: Bon = new Bon();
    bon.date = this.selectedDate;
    bon.geschaeft = this.selectedGeschaeft;
    this.currentBon = bon;
  }

  persistBon(): void {
    let bon: Bon = this.currentBon;
    let monatString = this.monate[this.selectedDate.getMonth()] + '' + (this.selectedDate.getFullYear() - 2000);
    this.monatService.getByName(monatString).toPromise().then(data => {
      bon.monat = data;
    }).then(() => {
      this.bonService.saveBon(bon).subscribe(data => {
        this.currentBon = data;
        this.saveBon();
      });
    });
  }

  saveBon(): void {
    if (!this.currentBon.id) {
      this.persistBon();
      return null;
    }
    for (let post of this.posten) {
      post.bon = this.currentBon;
      this.postenService.savePosten(post).subscribe(data => console.log(data));
    }

    this.router.navigateByUrl('/home');
  }

  changeDate($event): void {
    this.selectedDate = new Date($event.target.value);
  }

  onArtikelSelect(event: TypeaheadMatch): void {
    this.selectedArtikel = event.item;
  }

  triggerAddArticle(): void {
    this.showAddArticle = true;
  }

}
