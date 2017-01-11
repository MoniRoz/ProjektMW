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
  private formularzWyszukiwarki;
  private samochod: Samochod;
  // private samochod: Samochod = new Samochod('Osobowy', 'Ford', 'Sedan', 'Focus',
  //   '2008', 'W0L0XCF0814000002', 'F16D3000080K', 'WD70757', 'AWD23423456AAAA', '200000', 'Czerwony');

  constructor(private fb: FormBuilder,
              private service: StarostaService) {
    this.formularzRejestracji = fb.group({
      'rodzaj_pojazdu': [null, [Validators.required, Validators.pattern('^[A-Z][a-z]+')]],
      'marka': [null, [Validators.required, Validators.pattern('^[A-Z][a-z]+')]],
      'typ': [null, [Validators.required, Validators.pattern('^[A-Z][a-z]+')]],
      'model': [null, [Validators.required, Validators.pattern('^[A-Z][a-z]+')]],
      'rok_produkcji': [null, [Validators.required, Validators.pattern('^[1-2][0-9]{3}$')]],
      'nr_VIN': [null, [Validators.required, Validators.pattern('^[0-9A-HJ-NPR-Z]{17}$')]],
      'nr_silnika': [null, [Validators.required, Validators.pattern('^[A-Z0-9]{12}$')]],
      'd_nr_rejestracyjny': [null, [Validators.required, Validators.pattern('^[A-Z0-9]{7}$')]],
      'nr_kart_pojazdu': [null, [Validators.required, Validators.pattern('^[A-Z0-9]{15}$' || 'nie wydano')]],
      'przebieg_p_w_km': [null, [Validators.required, Validators.pattern('[0-9]*')]],
      'barwa_nadwozia': [null, [Validators.required, Validators.pattern('^[A-Z][a-z]+')]]
    });

    this.formularzWyszukiwarki = fb.group({
      'search': [null, Validators.pattern('^[0-9A-HJ-NPR-Z]{17}$')]
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
    );
    this.formularzWyszukiwarki.reset();
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
