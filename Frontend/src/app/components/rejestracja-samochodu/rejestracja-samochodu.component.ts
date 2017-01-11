import {Component, Output, EventEmitter, Input, SimpleChanges, OnChanges} from '@angular/core';
import {FormGroup, FormBuilder, Validators} from "@angular/forms";
import {Samochod} from "../../_mocks/samochod";
import {StarostaService} from "../../_services/starosta.service";

@Component({
  selector: 'rejestracja-samochodu',
  templateUrl: 'rejestracja-samochodu.component.html'
})
export class RejestracjaSamochodu implements OnChanges {
  @Input() reset: boolean;
  @Output() notify = new EventEmitter();
  private formularzRejestracji: FormGroup;
  //private samochod: Samochod;
  private samochod: Samochod = new Samochod('Samochod', 'Ford', 'sedan', 'Focus',
    '2008', 'W0L0XCF0814000002', 'F16D3000080K', 'WD70757', '23423456', '200000', 'czerwony');

  constructor(private fb: FormBuilder,
              private service: StarostaService) {
    this.formularzRejestracji = fb.group({
      'rodzaj_pojazdu': [null, [Validators.required, Validators.pattern('[a-zA-Z]*')]],
      'marka': [null, [Validators.required, Validators.pattern('[a-zA-Z]*')]],
      'typ': [null, [Validators.required, Validators.pattern('[a-zA-Z]*')]],
      'model': [null, [Validators.required, Validators.pattern('[a-zA-Z]*')]],
      'rok_produkcji': [null, [Validators.required, Validators.minLength(4), Validators.pattern('[0-9]{4,4}')]],
      'nr_VIN': [null, [Validators.required, Validators.pattern('[A-Z0-9]*')]],
      'nr_silnika': [null, [Validators.required, Validators.pattern('[A-Z0-9]*')]],
      'd_nr_rejestracyjny': [null, [Validators.required, Validators.pattern('[A-Z0-9]*')]],
      'nr_kart_pojazdu': [null, [Validators.required, Validators.pattern('[0-9]*')]],
      'przebieg_p_w_km': [null, [Validators.required, Validators.pattern('[0-9]*')]],
      'barwa_nadwozia': [null, [Validators.required, Validators.pattern('[a-zA-Z]*')]]
    });

    this.formularzRejestracji.valueChanges.subscribe(() => {
      this.notify.emit(this.formularzRejestracji);
    });
  }

  isVehicleExists(value: any) {
    console.log(value);
    this.service.getVehicle().subscribe(
      samochod => {
        this.samochod = samochod;
      },
      error => {
        console.log(error);
      }
    )
  }

  ngOnChanges(changes: SimpleChanges) {
    if (this.reset) {
      this.formularzRejestracji.reset();
    }

    if (!this.samochod) {
      this.samochod = new Samochod(null, null, null, null, null, null, null, null, null, null, null);
    }
  }
}
