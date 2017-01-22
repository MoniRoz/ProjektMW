import {Component, Output, EventEmitter, Input, SimpleChanges, OnChanges} from '@angular/core';
import {FormGroup, FormBuilder, Validators} from "@angular/forms";
import {Samochod} from "../../../_mocks/samochod";
import {StarostaService} from "../../../_services/starosta.service";
import {CarData} from "../../policjant/pojazd-informacje/przykladowy-samochod";

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

  constructor(private fb: FormBuilder,
              private service: StarostaService) {
    this.formularzRejestracji = fb.group({
      'rodzaj_pojazdu': [null, [Validators.required, Validators.pattern('^[A-Z][a-z]+')]],
      'marka': [null, [Validators.required, Validators.pattern('^[A-Z][a-z]+')]],
      'typ': [null, [Validators.required, Validators.pattern('^[A-Z][a-z]+')]],
      'model': [null, [Validators.required, Validators.pattern('^[A-Z][a-z]+')]],
      'rok_produkcji': [null, [Validators.required, Validators.pattern('^[1-2][0-9]{3}$')]],
      'nr_VIN': [null, [Validators.required, Validators.pattern('^[0-9A-HJ-NPR-Z]{17}$')]],
      'masa': [null, [Validators.required]],
      'd_nr_rejestracyjny': [null, [Validators.required, Validators.pattern('^[A-Z0-9]{7}$')]],
      'p_silnika': [null, [Validators.required]],
      'm_silnika': [null, [Validators.required]],
      'r_paliwa': [null, [Validators.required]]
    });

    this.formularzWyszukiwarki = fb.group({
      'search': [null, [Validators.required, Validators.pattern('^[0-9A-HJ-NPR-Z]{17}$')]]
    });

    this.formularzRejestracji.valueChanges.subscribe(() => {
      this.notify.emit(this.formularzRejestracji);
    });
  }

  isVehicleExists(VIN: string) {
    this.service.getVehicle(VIN).subscribe(
      samochod => {
        this.samochod = samochod;
      },
      error => {
        console.log(error);
        // this.samochod = new Samochod('a', 'a', 'a', 'a', 2005, 'a', 1, 'a', 1, 1, 'P');
      }
    );
    this.formularzWyszukiwarki.reset();
  }

  ngOnChanges(changes: SimpleChanges) {
    if (this.reset) {
      this.formularzRejestracji.reset();
      this.samochod = new Samochod(null, null, null, null, null, null, null, null, null, null, null);
    }

    if (!this.samochod) {
      this.samochod = new Samochod(null, null, null, null, null, null, null, null, null, null, null);
    }
  }
}
