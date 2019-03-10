import {Jahr} from "./Jahr";
import {Bon} from "./Bon";

export class Monat {

  id: number;

  jahr: Jahr;

  monat: number;
  name: string;

  bon: Bon[];
}
