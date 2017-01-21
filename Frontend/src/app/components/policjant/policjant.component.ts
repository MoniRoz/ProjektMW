import {Component, OnInit, OnChanges, DoCheck} from '@angular/core';
import {FormBuilder} from "@angular/forms";
import * as $ from 'jquery';
import {AutoService} from "../../_services/auto.service";
import {CarData} from './pojazd-informacje/przykladowy-samochod';
import {OwnersData} from "./wlascicele-informacje/przykladowi-wlasciciele";

@Component({
  selector: 'policjant',
  templateUrl: 'policjant.component.html',
  styleUrls: ['policjant.component.css']
})
export class Policjant implements OnInit,DoCheck {
  private formularzWyszukiwarki;
  private carChoosen: boolean = false;
  private carData: Array<any> = CarData;
  private ownerData: Array<any> = [];

  public constructor(private fb: FormBuilder,
                     private autoService: AutoService) {
    this.formularzWyszukiwarki = fb.group({
      'search': [null]
    });
  }

  ngOnInit(): void {
    $('.loader').hide();
    $('.content').hide();
  }

  ngDoCheck(): void {
    if (this.carChoosen)
      this.ownerData = OwnersData
  }

  private clicked(value: any) {
    this.formularzWyszukiwarki.reset();
    $('#message').hide();
    $('.loader').toggle();
    this.autoService.znajdzSamochod(value).subscribe(
      data => {
        console.log(data);
      }, error => {
        // setTimeout(() => {
        $('.loader').toggle();
        $('.content').fadeIn('slow');
        // }, 4000);
      });
  }
}
