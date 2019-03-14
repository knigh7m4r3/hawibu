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
import {TabsModule} from "ngx-bootstrap";

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    JahrListComponent,
    DetailjComponent
  ],
  imports: [
    CommonModule,
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    HttpClientModule,
    ChartsModule,
    TabsModule.forRoot()

  ],
  providers: [
    JahrListService,
    BonService,
    PostenService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
