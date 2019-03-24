import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {AppComponent} from '../app.component';
import {Artikel} from '../model/Artikel';

@Injectable({
  providedIn: 'root'
})
export class ArtikelService {

  constructor(private http: HttpClient) {
  }

  private artikelURL = AppComponent.baseURL + '/artikel';

  getAllArtikel(): Observable<Artikel[]> {
    return this.http.get<Artikel[]>(this.artikelURL);
  }

  save(art: Artikel): Observable<Artikel> {
    return this.http.post<Artikel>(this.artikelURL, art);
  }

}
