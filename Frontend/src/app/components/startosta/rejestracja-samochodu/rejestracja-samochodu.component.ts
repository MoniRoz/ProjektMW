import {Component, Output, EventEmitter, Input, SimpleChanges, OnChanges} from '@angular/core';
import {FormGroup, FormBuilder, Validators} from "@angular/forms";
import {Samochod} from "../../../_mocks/samochod";
import {StarostaService} from "../../../_services/starosta.service";
import {CarData} from "../../policjant/pojazd-informacje/przykladowy-samochod";
import {CarTypeValidator} from "../../../_validators/car_type.validator";
import {ProductionYearValidator} from "../../../_validators/production_year.validator";
import {VINValidator} from "../../../_validators/VIN.validator";
import {MassValidator} from "../../../_validators/mass.validator";
import {LogbookValidator} from "../../../_validators/logbook.validator";
import {ECCValidator} from "../../../_validators/engine-cubic-capacity.validator";
import {EPValidator} from "../../../_validators/engine-power.validator";
import {FTValidator} from "../../../_validators/fuel-type.validator";
import {CarMakeValidator} from "../../../_validators/car_make.validator";
import {CMValidator} from "../../../_validators/car-model.validator";

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
      'rodzaj_pojazdu': [null, [Validators.required, CarTypeValidator.patternValidator]],
      'marka': [null, [Validators.required, CarMakeValidator.patternValidator]],
      'model': [null, [Validators.required, CMValidator.patternValidator]],
      'rok_produkcji': [null, [Validators.required, ProductionYearValidator.patternValidator]],
      'nr_VIN': [null, [Validators.required, VINValidator.patternValidator]],
      'masa': [null, [Validators.required, MassValidator.patternValidator]],
      'd_nr_rejestracyjny': [null, [Validators.required, LogbookValidator.patternValidator]],
      'p_silnika': [null, [Validators.required, ECCValidator.patternValidator]],
      'm_silnika': [null, [Validators.required, EPValidator.patternValidator]],
      'r_paliwa': [null, [Validators.required, FTValidator.patternValidator]]
    });

    this.formularzWyszukiwarki = fb.group({
      'search': [null, [Validators.required, VINValidator.patternValidator]]
    });

    this.formularzRejestracji.valueChanges.subscribe(() => {
      this.notify.emit(this.formularzRejestracji);
    });
  }

  isVehicleExists(VIN: string) {
    this.samochod = new Samochod(null, null, null, null, null, null, null, null, null, null);
    this.formularzRejestracji.reset();
    this.formularzWyszukiwarki.reset();
    this.service.getVehicle(VIN).subscribe(
      samochod => {
        this.samochod = samochod;
      },
      error => {
        console.log(error);
      }
    );
  }

  ngOnChanges(changes: SimpleChanges) {
    if (this.reset) {
      this.formularzRejestracji.reset();
      this.samochod = new Samochod(null, null, null, null, null, null, null, null, null, null);
    }

    if (!this.samochod) {
      this.samochod = new Samochod(null, null, null, null, null, null, null, null, null, null);
    }
  }
}
