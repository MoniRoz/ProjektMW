import {Component, OnInit} from '@angular/core';
import {FormBuilder} from "@angular/forms";
import {AutoService} from "../../_services/auto.service";
import {CarData} from './pojazd-informacje/przykladowy-samochod';
import {OwnersData} from "./wlascicele-informacje/przykladowi-wlasciciele";
import {Samochod} from "../../_mocks/samochod";
import * as $ from 'jquery';

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
      $('#ownerLoad').show();
      setTimeout(() => {
        $('#ownerLoad').hide();
        this.ownerData = OwnersData;
      }, 2000);
    }
  }

  private clicked(value: any) {
    this.formularzWyszukiwarki.reset();
    $('.content').hide();
    $('#message').hide();
    $('#onLoad').toggle();
    this.autoService.znajdzSamochod(value).subscribe(
      data => {
        console.log(data);
      }, error => {
        console.log(error);
        $('#onLoad').toggle();
        $('.content').fadeIn('slow');
        this.carData = CarData;
      });
  }
}
