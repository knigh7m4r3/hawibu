import {Kategorie} from "./Kategorie";
import {Posten} from "./Posten";

export class Artikel {

  id: number;
  name: string;
  kategorie: Kategorie;
  posten: Posten[];

}
