import {EventEmitter, Injectable} from "@angular/core";

@Injectable()
export class JahrListService {

  currentSelection: string = "";

  emitter: EventEmitter<String> = new EventEmitter();

  constructor() { }

  setCurrentSelection(newVal: string){
    this.currentSelection = newVal;
    this.emitter.emit(this.currentSelection);

  }
}
