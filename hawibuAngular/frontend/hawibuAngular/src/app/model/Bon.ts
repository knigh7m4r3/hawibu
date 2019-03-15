import {Geschaeft} from "./Geschaeft";
import {Monat} from "./Monat";
import {Posten} from "./Posten";

export class Bon {
  id: number;
  date: Date;
  geschaeft: Geschaeft;
  monat: Monat;
  posten: Posten[];


}
