import {Component, OnInit} from '@angular/core';
import {Geschaeft} from "../model/Geschaeft";
import {GeschaeftService} from "../services/geschaeft.service";
import {Posten} from "../model/Posten";
import {ArtikelService} from "../services/artikel.service";
import {KategorieService} from "../services/kategorie.service";
import {Artikel} from "../model/Artikel";
import {Kategorie} from "../model/Kategorie";
import {Bon} from "../model/Bon";
import {MonatService} from "../services/monat.service";
import {BonService} from "../services/bon.service";
import {PostenService} from "../services/posten.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-bon',
  templateUrl: './bon.component.html',
  styleUrls: ['./bon.component.css']
})
export class BonComponent implements OnInit {
  monate: String[] = ["Januar ", "Februar ", "März ", "April ", "Mai ", "Juni ", "Juli ", "August ", "September ", "Oktober ", "November ", "Dezember "];


  isLoading: number = 0;
  maxSubscriptions : number = 0;

  geschaefte: Geschaeft[] = [];
  selectedGeschaeft: Geschaeft;

  selectedPreis: number;
  selectedMenge: number;

  posten: Posten[] =[];

  selectedDate: Date;

  artikel: Artikel[] = [];
  selectedArtikel: Artikel;

  kategorien: Kategorie[] =[];

  currentBon: Bon;behe

  currentGesamt: number = 0;

  constructor(private geschaeftService: GeschaeftService,
              private artikelService: ArtikelService,
              private kategorieService: KategorieService,
              private monatService: MonatService,
              private bonService: BonService,
              private postenService: PostenService,
              private router: Router) { }

  ngOnInit() {
    this.geschaeftService.getAllGeschaefte().subscribe(data => {
      this.geschaefte = data;
      ++this.isLoading;
    });
    this.artikelService.getAllArtikel().subscribe(data => {
      this.artikel = data;
      ++this.isLoading;
    });
    this.kategorieService.getAllKategorie().subscribe(data => {
      this.kategorien = data;
      ++this.isLoading;
    });
  }


  removePosten(post: Posten): void{
    this.currentGesamt -= post.menge * post.preis;

    const index = this.posten.indexOf(post, 0);
    if (index > -1) {
      this.posten.splice(index, 1);
    }

  }

  createPosten(): void{
    if(!this.currentBon){
      this.createCurrentBon();
    }

    console.log(this.selectedArtikel);
    let post: Posten = new Posten();
    post.preis = this.selectedPreis;
    post.menge = this.selectedMenge;
    post.artikel = this.selectedArtikel;
    post.bon = this.currentBon;

    this.posten.push(post);
    this.currentGesamt += this.selectedMenge * this.selectedPreis;

  }


  createCurrentBon():void {
    let bon: Bon = new Bon();
    bon.date = this.selectedDate;
    bon.geschaeft = this.selectedGeschaeft;
    this.currentBon = bon;
  }

  persistBon(): void{
    // TODO Monat in Bon speichern
    let bon: Bon = this.currentBon;
    let monatString = this.monate[this.selectedDate.getMonth()] + " " + (this.selectedDate.getFullYear() - 2000);
    this.monatService.getByName(monatString).toPromise().then( data =>   {
      bon.monat = data;
    } ).then(() => {
      this.bonService.saveBon(bon).subscribe(data => {
        this.currentBon = data;
        console.log(this.currentBon);
        this.saveBon();
      });
    });
  }

  saveBon():void{
  //  TODO Bon abspeichern
    if(!this.currentBon.id){
      this.persistBon();
      return null;
    }
    for(let post of this.posten){
      console.log(post.bon);
      console.log(this.currentBon);
      post.bon = this.currentBon;
      this.postenService.savePosten(post).subscribe(data => console.log(data));
    }

    this.router.navigateByUrl("/home");
  }

  changeDate($event): void{
    this.selectedDate = new Date($event.target.value);
  }
}
