import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Bon} from "../model/Bon";
import {Posten} from "../model/Posten";

@Injectable({
  providedIn: 'root'
})
export class PostenService {

  constructor(private http: HttpClient) { }

  private postenURL = "http://localhost:4200/hawibuAngular_war/api/posten";

  getAllByBons(bon: Bon[]): Observable<Posten[]>{
    return this.http.post<Posten[]>(this.postenURL + "/byBons", bon);
  }

}
