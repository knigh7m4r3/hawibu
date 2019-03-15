import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {BonComponent} from "./bon/bon.component";
import {DetailjComponent} from "./detailj/detailj.component";



const routes: Routes = [
  {path : 'createBon', component : BonComponent},
  {path: '' , redirectTo:'/home',pathMatch:'full'},
  {path : 'home', component : DetailjComponent}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
