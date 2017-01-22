import {Component, OnInit} from '@angular/core';
import {FormBuilder} from "@angular/forms";
import {CarData} from "../policjant/pojazd-informacje/przykladowy-samochod";
import * as $ from 'jquery';
import set = Reflect.set;
import {PrzegladInfo} from "../policjant/przeglad-informacje/przeglad-informacje.component";
import {PrzegladyData} from "../policjant/przeglad-informacje/przykladowe-przeglady";
import {Samochod} from "../../_mocks/samochod";

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

  public constructor(private fb: FormBuilder) {
    this.formularzWyszukiwarki = fb.group({
      'search': [null]
    });
  }

  myChange(value) {
    this.carChoosen = value;
    $('#ownerLoad').show();
    if (this.carChoosen != null) {
      setTimeout(() => {
        $('#ownerLoad').hide();
        this.przegladyData = PrzegladyData;
      }, 2000)
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
    setTimeout(() => {
      $('#onLoad').toggle();
      $('.content').fadeIn('slow');
      this.carData = CarData;
      console.log(this.carData)
    }, 2000);
  }
}
