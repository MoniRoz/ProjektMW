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
      'rodzaj_pojazdu': [null,Validators.pattern('[a-zA-Z]*')],
      'marka': [null,Validators.pattern('[a-zA-Z]*')],
      'typ': [null,Validators.pattern('[a-zA-Z]*')],
      'model': [null,Validators.pattern('[a-zA-Z]*')],
      'rok_produkcji': [null,[Validators.minLength(4),Validators.pattern('[0-9]{4,4}')]],
      'nr_VIN': [null,Validators.pattern('[A-Z0-9]*')],
      'nr_silnika': [null,Validators.pattern('[A-Z0-9]*')],
      'd_nr_rejestracyjny': [null,Validators.pattern('[A-Z0-9]*')],
      'nr_kart_pojazdu': [null,Validators.pattern('[0-9]*')],
      'przebieg_p_w_km': [null,Validators.pattern('[0-9]*')],
      'barwa_nadwozia': [null,Validators.pattern('[a-zA-Z]*')]
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
