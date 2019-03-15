import { Injectable } from '@angular/core';
import {Jahr} from "../model/Jahr";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class JahrService {

  constructor(private http: HttpClient) { }

  private jahrURL = "http://localhost:8080/hawibu_war/api/jahr";
  getAllJahr(): Observable<Jahr[]>{
    return this.http.get<Jahr[]>(this.jahrURL);
  }
}
