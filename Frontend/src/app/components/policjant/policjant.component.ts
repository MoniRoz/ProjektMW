import {Component, OnInit, OnChanges, DoCheck, SimpleChanges} from '@angular/core';
import {FormBuilder} from "@angular/forms";
import * as $ from 'jquery';
import {AutoService} from "../../_services/auto.service";
import {CarData} from './pojazd-informacje/przykladowy-samochod';
import {OwnersData} from "./wlascicele-informacje/przykladowi-wlasciciele";
import {Samochod} from "../../_mocks/samochod";

@Component({
  selector: 'policjant',
  templateUrl: 'policjant.component.html',
  styleUrls: ['policjant.component.css']
})
export class Policjant implements OnInit {

  private formularzWyszukiwarki;
  private carChoosen: Samochod = null;
  private carData: Array<any> = [];
  private ownerData: Array<any> = [];

  public constructor(private fb: FormBuilder,
                     private autoService: AutoService) {
    this.formularzWyszukiwarki = fb.group({
      'search': [null]
    });
  }

  ngOnInit(): void {
    $('#onLoad').hide();
    $('#ownerLoad').hide();
    $('.content').hide();

  }

  myChange(value) {
    this.carChoosen = value;
    this.ownerData = [];

    if (this.carChoosen != null) {
      console.log("checked");
      $('#ownerLoad').show();
      setTimeout(() => {
        $('#ownerLoad').hide();
        this.ownerData = OwnersData;
      }, 4000);
    }
  }

  private clicked(value: any) {
    this.formularzWyszukiwarki.reset();
    $('#message').hide();
    $('#onLoad').toggle();
    this.autoService.znajdzSamochod(value).subscribe(
      data => {
        console.log(data);
      }, () => {
        $('#onLoad').toggle();
        $('.content').fadeIn('slow');
        this.carData = CarData;
      });
  }
}
