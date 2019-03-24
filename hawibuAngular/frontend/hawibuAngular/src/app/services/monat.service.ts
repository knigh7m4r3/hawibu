import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {Jahr} from "../model/Jahr";
import {HttpClient} from "@angular/common/http";
import {Monat} from "../model/Monat";
import {AppComponent} from "../app.component";

@Injectable({
  providedIn: 'root'
})
export class MonatService {

  constructor(private http: HttpClient) { }

  private monatURL = AppComponent.baseURL + "/monat";
  getAllMonat(): Observable<Monat[]>{
    return this.http.get<Monat[]>(this.monatURL);
  }

  getAllJahrByDistinctMonat(monate:Monat[]): Observable<Jahr[]>{
    return this.http.post<Jahr[]>(this.monatURL + "/getJahrByMonat", monate);
  }

  getByName(monatName: string): Observable<Monat>{
    return this.http.get<Monat>(this.monatURL + "/byName/" + monatName);
  }

}
