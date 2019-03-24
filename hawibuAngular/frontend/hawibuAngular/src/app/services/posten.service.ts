import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Bon} from "../model/Bon";
import {Posten} from "../model/Posten";
import {AppComponent} from "../app.component";

@Injectable({
  providedIn: 'root'
})
export class PostenService {

  constructor(private http: HttpClient) { }

  private postenURL = AppComponent.baseURL + "/posten";

  getAllByBons(bon: Bon[]): Observable<Posten[]>{
    return this.http.post<Posten[]>(this.postenURL + "/byBons", bon);
  }

  savePosten(posten: Posten): Observable<Posten>{
    return this.http.post<Posten>(this.postenURL, posten);

  }

}
