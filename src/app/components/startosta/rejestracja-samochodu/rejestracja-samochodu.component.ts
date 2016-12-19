import {Component} from '@angular/core';
import {FormGroup, FormBuilder, Validators} from "@angular/forms";
import {Samochod} from "../../../_mocks/samochod";
import {AutoService} from "../../../_services/auto.service";

@Component({
  selector: 'rejestracja-samochodu',
  templateUrl: 'rejestracja-samochodu.component.html'
})
export class RejestracjaSamochodu {
  formularzRejestracji: FormGroup;

  constructor(private fb: FormBuilder,
              private autoService: AutoService) {
    this.formularzRejestracji = fb.group({
      'rodzaj_pojazdu': [null],
      'marka': [null],
      'typ': [null],
      'model': [null],
      'rok_produkcji': [null],
      'nr_VIN': [null],
      'nr_silnika': [null],
      'd_nr_rejestracyjny': [null],
      'nr_kart_pojazdu': [null],
      'przebieg_p_w_km': [null],
      'barwa_nadwozia': [null]
    });
  }

  submit(samochod: Samochod) {
    this.autoService.nowySamochod(samochod).subscribe(
      data => {
        console.log('Data: ' + data);
        this.formularzRejestracji.reset();
      },
      error => {
        this.formularzRejestracji.reset();
      });
    console.log(samochod);
    this.formularzRejestracji.reset();
  }
}
