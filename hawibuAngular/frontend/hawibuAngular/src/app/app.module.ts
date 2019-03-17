import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HeaderComponent} from './header/header.component';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {JahrListComponent} from './jahr-list/jahr-list.component';
import {DetailjComponent} from './detailj/detailj.component';
import {HttpClientModule} from "@angular/common/http";
import {CommonModule} from "@angular/common";
import {JahrListService} from "./jahr-list/jahr.service";
import {BonService} from "./services/bon.service";
import {PostenService} from "./services/posten.service";
import {ChartsModule} from "ng2-charts";
import {ModalModule, TabsModule} from "ngx-bootstrap";
import { BonComponent } from './bon/bon.component';
import {FormsModule} from "@angular/forms";
import {GeschaeftService} from "./services/geschaeft.service";
import {KategorieService} from "./services/kategorie.service";
import {ArtikelService} from "./services/artikel.service";
import {MonatService} from "./services/monat.service";

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    JahrListComponent,
    DetailjComponent,
    BonComponent
  ],
  imports: [
    CommonModule,
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    HttpClientModule,
    ChartsModule,
    FormsModule,
    TabsModule.forRoot(),
    ModalModule.forRoot()

  ],
  providers: [
    JahrListService,
    BonService,
    PostenService,
    GeschaeftService,
    KategorieService,
    ArtikelService,
    MonatService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
