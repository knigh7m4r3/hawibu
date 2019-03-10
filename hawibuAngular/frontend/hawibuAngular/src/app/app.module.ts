import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HeaderComponent} from './header/header.component';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {JahrListComponent} from './jahr-list/jahr-list.component';
import {DetailjComponent} from './detailj/detailj.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    JahrListComponent,
    DetailjComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
