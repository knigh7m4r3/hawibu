import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Bon} from "../model/Bon";

@Injectable({
  providedIn: 'root'
})
export class BonService {

  constructor(private http: HttpClient) { }

  private bonURL = "http://localhost:4200/hawibuAngular_war/api/bon";
  getAllBon(): Observable<Bon[]>{
    return this.http.get<Bon[]>(this.bonURL);
  }

  getAllBonByMonat(monat: string): Observable<Bon[]>{
    return this.http.get<Bon[]>(this.bonURL +  "/byMonat/" + monat );
  }

  getAllBonByJahr(jahr: string): Observable<Bon[]>{
    return this.http.get<Bon[]>(this.bonURL + "/byJahr/" + jahr);
  }
}
