import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Geschaeft} from "../model/Geschaeft";
import {AppComponent} from "../app.component";

@Injectable({
  providedIn: 'root'
})
export class GeschaeftService {

  constructor(private http: HttpClient) { }

  private bonURL = AppComponent.baseURL + "/geschaeft";
  getAllGeschaefte(): Observable<Geschaeft[]>{
    return this.http.get<Geschaeft[]>(this.bonURL);
  }


}
