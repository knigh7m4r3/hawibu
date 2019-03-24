import {CommonModule} from '@angular/common';
import {HttpClientModule} from '@angular/common/http';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {BrowserModule} from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {AngularFontAwesomeModule} from 'angular-font-awesome';
import {ChartsModule} from 'ng2-charts';
import {AlertModule, ModalModule, TabsModule, TypeaheadModule} from 'ngx-bootstrap';
import {AddArticleComponent} from './add-article/add-article.component';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {BonComponent} from './bon/bon.component';
import {DetailjComponent} from './detailj/detailj.component';
import {HeaderComponent} from './header/header.component';
import {JahrListComponent} from './jahr-list/jahr-list.component';
import {JahrListService} from './jahr-list/jahr.service';
import {ArtikelService} from './services/artikel.service';
import {BonService} from './services/bon.service';
import {GeschaeftService} from './services/geschaeft.service';
import {KategorieService} from './services/kategorie.service';
import {MonatService} from './services/monat.service';
import {PostenService} from './services/posten.service';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    JahrListComponent,
    DetailjComponent,
    BonComponent,
    AddArticleComponent],
  imports: [
    NgbModule,
    AngularFontAwesomeModule,
    CommonModule,
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    HttpClientModule,
    ChartsModule,
    FormsModule,
    TabsModule.forRoot(),
    ModalModule.forRoot(),
    TypeaheadModule.forRoot(),
    AlertModule.forRoot()],
  providers: [
    JahrListService,
    BonService,
    PostenService,
    GeschaeftService,
    KategorieService,
    ArtikelService,
    MonatService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
