import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {AppComponent} from '../app.component';
import {Kategorie} from '../model/Kategorie';

@Injectable({
  providedIn: 'root'
})
export class KategorieService {

  constructor(private http: HttpClient) {
  }

  private katURL = AppComponent.baseURL + '/kategorie';

  getAllKategorie(): Observable<Kategorie[]> {
    return this.http.get<Kategorie[]>(this.katURL);
  }

  saveKategorie(name: string): Observable<Kategorie> {
    const kat: Kategorie = new Kategorie();
    kat.name = name;
    console.log(kat);
    return this.http.post<Kategorie>(this.katURL, kat);
  }

}
