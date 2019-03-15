import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Artikel} from "../model/Artikel";

@Injectable({
  providedIn: 'root'
})
export class ArtikelService {

  constructor(private http: HttpClient) { }

  private bonURL = "http://localhost:4200/hawibuAngular_war/api/artikel";
  getAllArtikel(): Observable<Artikel[]>{
    return this.http.get<Artikel[]>(this.bonURL);
  }
}
