import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Kategorie} from "../model/Kategorie";

@Injectable({
  providedIn: 'root'
})
export class KategorieService {

  constructor(private http: HttpClient) { }

  private bonURL = "http://localhost:4200/hawibuAngular_war/api/kategorie";
  getAllKategorie(): Observable<Kategorie[]>{
    return this.http.get<Kategorie[]>(this.bonURL);
  }
}
