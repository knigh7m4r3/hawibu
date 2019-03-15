import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Geschaeft} from "../model/Geschaeft";

@Injectable({
  providedIn: 'root'
})
export class GeschaeftService {

  constructor(private http: HttpClient) { }

  private bonURL = "http://localhost:4200/hawibuAngular_war/api/geschaeft";
  getAllGeschaefte(): Observable<Geschaeft[]>{
    return this.http.get<Geschaeft[]>(this.bonURL);
  }


}
