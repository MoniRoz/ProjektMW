import {Component, OnInit} from '@angular/core';
import {FormBuilder} from "@angular/forms";
import {CarData} from "../policjant/pojazd-informacje/przykladowy-samochod";
import {PrzegladyData} from "../policjant/przeglad-informacje/przykladowe-przeglady";
import {Samochod} from "../../_mocks/samochod";
import {AutoService} from "../../_services/auto.service";
import * as $ from 'jquery';
import {VINValidator} from "../../_validators/VIN.validator";
import {PoliceSearchValidator} from "../../_validators/police-search.validator";

@Component({
  selector: 'skp',
  templateUrl: 'skp.component.html',
  styleUrls: ['skp.component.css']
})
export class SKP implements OnInit {
  private formularzWyszukiwarki;
  private message;
  private carChoosen: Samochod = null;
  private carData: Array<any> = [];
  private przegladyData: Array<any> = [];

  public constructor(private autoService: AutoService,
                     private fb: FormBuilder) {
    this.formularzWyszukiwarki = fb.group({
      'search': [null,PoliceSearchValidator.patternValidator]
    });
  }

  myChange(value) {
    this.carChoosen = value;
    this.przegladyData = [];

    $('#ownerLoad').show();
    if (this.carChoosen != null) {
      $('#brakPrzegladow').hide();
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

  ngOnInit(): void {
    $('#onLoad').hide();
    $('#ownerLoad').hide();
    $('.content').hide();

  }

  nowyPrzeglad(value: any) {
    if (this.carChoosen == null)
      var car = this.carData[0];
    else
      car = this.carChoosen;
    this.carData = [];
    this.przegladyData = [];
    $('.content').hide();
    $('#onLoad').toggle();
    this.autoService.nowyPrzeglad(car.nr_VIN, value).subscribe(
      data => {
        this.message = 'Przegląd dodano pomyślnie';
        $('#onLoad').toggle();
      },
      error => {
        this.message = 'Coś poszło nie tak, spróbuj ponownie';
        $('#onLoad').toggle();
      }
    );
    $('#infoPrzeglad').show();
  }

  clicked(value: any) {
    this.formularzWyszukiwarki.reset();
    this.carData = [];
    this.przegladyData = [];
    this.message = null;
    $('.content').hide();
    $('.infomessage').hide();
    $('#onLoad').toggle();
    this.autoService.znajdzSamochody(value).subscribe(
      data => {
        if (data[0] != null) {
          $('nowy-przeglad').show();
          this.carData = data;
        } else {
          $('nowy-przeglad').hide();
          $('#message').text('Brak winików').show();
        }
        $('#onLoad').toggle();
        $('.content').fadeIn('slow');
      }, error => {
        $('nowy-przeglad').hide();
        $('#message').text('Brak winików').show();
        $('#onLoad').toggle();
        $('.content').fadeIn('slow');
      });
  }
}
