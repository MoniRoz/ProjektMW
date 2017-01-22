import {Component, OnInit} from '@angular/core';
import {FormBuilder, Validators} from "@angular/forms";
import {AutoService} from "../../_services/auto.service";
import {CarData} from './pojazd-informacje/przykladowy-samochod';
import {OwnersData} from "./wlascicele-informacje/przykladowi-wlasciciele";
import {Samochod} from "../../_mocks/samochod";
import * as $ from 'jquery';
import {PrzegladyData} from "./przeglad-informacje/przykladowe-przeglady";

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
    this.przegladyData = [];

    if (this.carChoosen != null) {
      $('#ownerLoad').show();
      this.autoService.znajdzWlascicieli(this.carChoosen).subscribe(
        data => {
          console.log(data);
          $('#ownerLoad').hide();
          this.ownerData = OwnersData;
        }, error => {
          console.log(error);
          $('#ownerLoad').hide();
          this.ownerData = OwnersData;
        }
      );
      this.autoService.znajdzPrzeglady(this.carChoosen).subscribe(
        data => {
          console.log(data);
          $('#ownerLoad').hide();
          this.przegladyData = PrzegladyData;
        }, error => {
          console.log(error);
          $('#ownerLoad').hide();
          this.przegladyData = PrzegladyData;
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
        console.log("data", data);
        $('#onLoad').toggle();
        $('.content').fadeIn('slow');
        let samochod: Array<any> = [];
        samochod.push(new Samochod('a', 'a', 'a', 2008, 'a', 1111, 'a', 1.2, 1.3, 'a'));
        this.carData = samochod;
        console.log("car data: ", this.carData);
      }, error => {
        console.log(error);
        $('#onLoad').toggle();
        $('.content').fadeIn('slow');
        this.carData = CarData;
      });
  }
}
