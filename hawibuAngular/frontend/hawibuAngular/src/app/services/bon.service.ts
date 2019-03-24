import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Bon} from "../model/Bon";
import {AppComponent} from "../app.component";

@Injectable({
  providedIn: 'root'
})
export class BonService {

  constructor(private http: HttpClient) { }

  private bonURL = AppComponent.baseURL + "/bon";
  getAllBon(): Observable<Bon[]>{
    return this.http.get<Bon[]>(this.bonURL);
  }

  getAllBonByMonat(monat: string): Observable<Bon[]>{
    return this.http.get<Bon[]>(this.bonURL +  "/byMonat/" + monat );
  }

  getAllBonByJahr(jahr: string): Observable<Bon[]>{
    return this.http.get<Bon[]>(this.bonURL + "/byJahr/" + jahr);
  }


  saveBon(bon: Bon): Observable<Bon>{
    return this.http.post<Bon>(this.bonURL, bon);
  }
}
