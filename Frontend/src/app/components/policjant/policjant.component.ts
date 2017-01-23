import {Component, OnInit} from '@angular/core';
import {FormBuilder, Validators} from "@angular/forms";
import {AutoService} from "../../_services/auto.service";
import {CarData} from './pojazd-informacje/przykladowy-samochod';
import {OwnersData} from "./wlascicele-informacje/przykladowi-wlasciciele";
import {Samochod} from "../../_mocks/samochod";
import * as $ from 'jquery';
import {PrzegladyData} from "./przeglad-informacje/przykladowe-przeglady";
import {Wlasciciel} from "../../_mocks/wlasciciel";
import {PoliceSearchValidator} from "../../_validators/police-search.validator";

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
  private przegladyData: Array<any> = [];

  public constructor(private fb: FormBuilder,
                     private autoService: AutoService) {
    this.formularzWyszukiwarki = fb.group({
      'search': [null, PoliceSearchValidator.patternValidator]
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
    this.przegladyData = [];

    if (this.carChoosen != null) {
      $('#brakPrzegladow').hide();
      $('#ownerLoad').show();
      this.autoService.znajdzWlascicieli(this.carChoosen).subscribe(
        data => {
          console.log(data);
          $('#ownerLoad').hide();
          for (let i = 0; i < data.length; i++) {
            if (data[i].data_koncowa == null)
              data[i].data_koncowa = '-';
          }
          this.ownerData = data;
          if (data.length <= 0)
            $('#brakWlascicieli').show();
        }, error => {
          console.log(error);
          $('#ownerLoad').hide();
        }
      );
      this.autoService.znajdzPrzeglady(this.carChoosen).subscribe(
        data => {
          console.log(data);
          $('#ownerLoad').hide();
          this.przegladyData = data;
          if (data.length <= 0)
            $('#brakPrzegladow').show();
        }, error => {
          console.log(error);
          $('#ownerLoad').hide();
        }
      );
    }
  }

  private clicked(value: any) {
    this.formularzWyszukiwarki.reset();
    this.carData = [];
    this.ownerData = [];
    this.przegladyData = [];
    $('.content').hide();
    $('.infomessage').hide();
    $('#onLoad').toggle();
    this.autoService.znajdzSamochody(value).subscribe(
      data => {
        $('#onLoad').toggle();
        $('.content').fadeIn('slow');
        if (data[0] != null) {
          this.carData = data;
        } else
          $('#info').text('Brak winików').show();
      }, error => {
        console.log(error);
        $('#onLoad').toggle();
        $('.content').fadeIn('slow');
        $('#info').text('Brak winików').show();
      });
  }
}
