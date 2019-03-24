import {EventEmitter, Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ArticleBonService {

  public  emitter: EventEmitter<boolean> = new EventEmitter();
  constructor() { }

  triggerState(): void{
    this.emitter.emit(false);
  }
}
