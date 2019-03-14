import {Component, OnDestroy, OnInit} from '@angular/core';
import {JahrListService} from "../jahr-list/jahr.service";
import {Observable, Subscription} from "rxjs";
import {BonService} from "../services/bon.service";
import {Bon} from "../model/Bon";
import {PostenService} from "../services/posten.service";
import {Label, SingleDataSet} from "ng2-charts";
import {ChartOptions, ChartType} from "chart.js";
@Component({
  selector: 'app-detailj',
  templateUrl: './detailj.component.html',
  styleUrls: ['./detailj.component.css']
})
export class DetailjComponent implements OnInit, OnDestroy {

  constructor(private jahrListService: JahrListService, private bonService: BonService, private postenService: PostenService) { }
  private subscription: Subscription;

  private bonList: Bon[] = [];

  currentSelection: string = "";

  currentGesamt: number = 0.0;

  katMap: Map<string, number> = new Map<string, number>();

  // Pie
  public pieChartOptions: ChartOptions = {
    responsive: true,
    plugins: {
      datalabels: {
        formatter: (value, ctx) => {
          const label = ctx.chart.data.labels[ctx.dataIndex];
          return label;
        },
      },
    }
  };
  public pieChartLabels: Label[] = [];
  public pieChartData: SingleDataSet = [];
  public pieChartType: ChartType = 'pie';
  public pieChartLegend = true;

  ngOnInit() {
    this.subscription = this.jahrListService.emitter.subscribe(data => {
      this.currentSelection = data;
      this.updateData();
    })
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }

  private updateData():void{
    let obsBon: Observable<Bon[]>;
    if(this.currentSelection.length == 4){
      obsBon = this.bonService.getAllBonByJahr(this.currentSelection);
    }else{
      obsBon = this.bonService.getAllBonByMonat(this.currentSelection);
    }
    obsBon.subscribe(data=>{
      this.bonList = data;
      if(this.bonList.length !== 0) {
        this.processNewBonList();
      }else{
        this.currentSelection = "";
      }
    })
  }

  private processNewBonList():void{
    this.currentGesamt = 0;
    this.katMap = new Map<string, number>();
    this.postenService.getAllByBons(this.bonList).subscribe(data => {
      for(let posten of data){
        let kat: string = posten.artikel.kategorie.name;
        if(!this.katMap.has(kat)){
          this.katMap.set(kat, 0.0);
        }
        this.katMap.set(kat, this.katMap.get(kat) + (posten.menge * posten.preis));
        this.currentGesamt += posten.preis * posten.menge;
      }


      let tmp: number[] = [];
      this.pieChartLabels = [];
      this.katMap.forEach((value: number, key: string) => {
        this.pieChartLabels.push(key);
        tmp.push(value);
      });
      this.pieChartData = tmp;


    })

  }

}
