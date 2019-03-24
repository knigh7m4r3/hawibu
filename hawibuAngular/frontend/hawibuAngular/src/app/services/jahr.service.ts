import { Injectable } from '@angular/core';
import {Jahr} from "../model/Jahr";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {AppComponent} from "../app.component";

@Injectable({
  providedIn: 'root'
})
export class JahrService {

  constructor(private http: HttpClient) { }

  private jahrURL = AppComponent.baseURL + "/jahr";
  getAllJahr(): Observable<Jahr[]>{
    return this.http.get<Jahr[]>(this.jahrURL);
  }
}
