import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {Jahr} from "../model/Jahr";
import {HttpClient} from "@angular/common/http";
import {Monat} from "../model/Monat";

@Injectable({
  providedIn: 'root'
})
export class MonatService {

  constructor(private http: HttpClient) { }

  private monatURL = "http://localhost:8080/hawibu_war/api/monat";
  getAllMonat(): Observable<Monat[]>{
    return this.http.get<Monat[]>(this.monatURL);
  }

  getAllJahrByDistinctMonat(monate:Monat[]): Observable<Jahr[]>{
    return this.http.post<Jahr[]>(this.monatURL + "/getJahrByMonat", monate);
  }

}
