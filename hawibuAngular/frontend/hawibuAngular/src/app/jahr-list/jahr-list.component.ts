import {Component, OnInit} from '@angular/core';
import {JahrListService} from "./jahr.service";

@Component({
  selector: 'app-jahr-list',
  templateUrl: './jahr-list.component.html',
  styleUrls: ['./jahr-list.component.css']
})
export class JahrListComponent implements OnInit {

  startJahr: number = 2016;

  selectedJahr: String  = "";
  selectedItem: String = "";


  jahre: String[] = [];

  jahrMonatMap = new Map<String, String[]>();

  monate: String[] = ["Januar ", "Februar ", "März ", "April ", "Mai ", "Juni ", "Juli ", "August ", "September ", "Oktober ", "November ", "Dezember "];

  constructor(private jahrListService: JahrListService) {
  }

  ngOnInit() {
    let today = new Date();
    let currentJahr = today.getFullYear();
    for(let i = this.startJahr; i<= currentJahr;++i){
      this.jahre.push(i+"");
      let jahrMonate: String[] = [];
      for(let j = 0; j<this.monate.length;++j){
        jahrMonate.push(this.monate[j] + "" + (i - 2000));
      }
      this.jahrMonatMap.set(i+"", jahrMonate);
    }

  }

  handleJahrClick(jahr: string): void{
    this.selectedJahr = jahr;
    this.changeSelection(jahr);
  }


  handleMonatClick(monat: string): void{
    this.changeSelection(monat);
  }

  private changeSelection(selection: string): void{
    this.selectedItem = selection;
    this.jahrListService.setCurrentSelection(selection);
  }

}
