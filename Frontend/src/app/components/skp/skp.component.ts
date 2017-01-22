import {Component, OnInit} from '@angular/core';
import {FormBuilder} from "@angular/forms";
import {CarData} from "../policjant/pojazd-informacje/przykladowy-samochod";
import * as $ from 'jquery';
import set = Reflect.set;
import {PrzegladInfo} from "../policjant/przeglad-informacje/przeglad-informacje.component";
import {PrzegladyData} from "../policjant/przeglad-informacje/przykladowe-przeglady";
import {Samochod} from "../../_mocks/samochod";
import {AutoService} from "../../_services/auto.service";

@Component({
  selector: 'skp',
  templateUrl: 'skp.component.html',
  styleUrls: ['skp.component.css']
})
export class SKP implements OnInit {
  private formularzWyszukiwarki;
  private carChoosen: Samochod = null;
  private carData: Array<any> = [];
  private przegladyData: Array<any> = [];

  public constructor(private autoService: AutoService,
                     private fb: FormBuilder) {
    this.formularzWyszukiwarki = fb.group({
      'search': [null]
    });
  }

  myChange(value) {
    this.carChoosen = value;
    $('#ownerLoad').show();
    if (this.carChoosen != null) {
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

  ngOnInit(): void {
    $('#onLoad').hide();
    $('#ownerLoad').hide();
    $('.content').hide();

  }

  private clicked(value: any) {
    this.formularzWyszukiwarki.reset();
    this.carData = [];
    this.przegladyData = [];
    $('.content').hide();
    $('#message').hide();
    $('#onLoad').toggle();
    this.autoService.znajdzSamochody(value).subscribe(
      data => {
        console.log(data);
        $('#onLoad').toggle();
        $('.content').fadeIn('slow');
        this.carData = CarData;
      }, error => {
        console.log(error);
        $('#onLoad').toggle();
        $('.content').fadeIn('slow');
        this.carData = CarData;
      });
  }
}
