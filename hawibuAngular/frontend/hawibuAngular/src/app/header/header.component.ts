import { Component, OnInit } from '@angular/core';
import {JahrService} from "../services/jahr.service";
import {Jahr} from "../model/Jahr";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private jahrService: JahrService) { }

  jahrList: Jahr[];

  ngOnInit() {


  }

}
