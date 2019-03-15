import { Component, OnInit } from '@angular/core';
import {Geschaeft} from "../model/Geschaeft";
import {GeschaeftService} from "../services/geschaeft.service";
import {Posten} from "../model/Posten";
import {ArtikelService} from "../services/artikel.service";
import {KategorieService} from "../services/kategorie.service";
import {Artikel} from "../model/Artikel";
import {Kategorie} from "../model/Kategorie";
import {Bon} from "../model/Bon";

@Component({
  selector: 'app-bon',
  templateUrl: './bon.component.html',
  styleUrls: ['./bon.component.css']
})
export class BonComponent implements OnInit {


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
              private kategorieService: KategorieService) { }

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

  saveBon():void{
  //  TODO Bon abspeichern
    console.log(this.currentBon);
  }
}
