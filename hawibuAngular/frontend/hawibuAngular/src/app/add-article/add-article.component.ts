import {Component, OnDestroy, OnInit} from '@angular/core';
import {Artikel} from '../model/Artikel';
import {Kategorie} from '../model/Kategorie';
import {ArticleBonService} from '../services/article-bon.service';
import {ArtikelService} from '../services/artikel.service';
import {KategorieService} from '../services/kategorie.service';

@Component({
  selector: 'app-add-article',
  templateUrl: './add-article.component.html',
  styleUrls: ['./add-article.component.css']
})
export class AddArticleComponent implements OnInit, OnDestroy {

  currentArticleName = '';

  currentAlerts: any[] = [];

  kategorien: Kategorie[] = [];

  currentKategorie: Kategorie;
  currentKategorieString: string = '';

  constructor(private artBonService: ArticleBonService, private kategorieService: KategorieService, private artikelService: ArtikelService) {
  }

  ngOnInit() {
    this.kategorieService.getAllKategorie().subscribe(data => {
      this.kategorien = data;
    });

  }

  ngOnDestroy(): void {
  }

  closeAddArticle(): void {
    this.artBonService.triggerState();
  }

  checkInput($event): void {
    console.log($event.target.value);
  }

  async save() {
    if (!(this.currentKategorie && this.currentKategorie.name === this.currentKategorieString)) {
      let waitFlag: boolean = false;
      console.log('Nicht identischer Name! Kategorie wird neu erstellt!');
      this.kategorieService.saveKategorie(this.currentKategorieString).subscribe(data => {
        this.currentKategorie = data;
        waitFlag = true;
      });

      while (!this.currentKategorie) {
        console.log('.');

        await this.delay(100);
      }

    }

    if (!this.currentArticleName.match('[a-zA-Z0-9]')) {
      this.currentAlerts.push({
        type: 'danger',
        msg: 'Dieser Artikelname ist nicht zulässig! Nur A-Z a-z 0-9!',
        timeout: 5000
      });
      return;
    }

    const art: Artikel = new Artikel();
    art.kategorie = this.currentKategorie;
    art.name = this.currentArticleName;
    let article: Artikel = null;
    this.artikelService.save(art).subscribe(data => {
      article = data;
    });
    while (!this.currentKategorie) {
      console.log('.');

      await this.delay(100);
    }

    this.closeAddArticle();
  }

  delay(ms: number) {
    return new Promise(resolve => setTimeout(resolve, ms));
  }

  onKategorieSelect($event): void {
    if (!$event.item) {
      console.log('item is undefined!');
      this.currentKategorie = null;
    } else {
      console.log('item is defined!');
      this.currentKategorie = $event.item;
    }
  }

}
