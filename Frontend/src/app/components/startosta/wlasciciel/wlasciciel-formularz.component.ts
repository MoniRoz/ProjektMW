import {Component, EventEmitter, Output, Input, OnChanges, SimpleChanges} from '@angular/core';
import {FormGroup, FormBuilder, Validators, Validator} from "@angular/forms";
import {Wlasciciel} from "../../../_mocks/wlasciciel";
import {StarostaService} from "../../../_services/starosta.service";
import {NameValidator} from "../../../_validators/name.validator";
import {LastnameValidator} from "../../../_validators/lastname.validator";
import {StreetValidator} from "../../../_validators/street.validator";
import {HousenumberValidator} from "../../../_validators/house_number.validator";
import {PostcodeValidator} from "../../../_validators/poste-code.validator";
import {TownValidator} from "../../../_validators/town.validator";
import {P_I_NumberValidator} from "../../../_validators/personal-identit- number.component";

@Component({
  selector: 'wlasciciel-formularz',
  templateUrl: 'wlasciciel-formularz.component.html'
})
export class FormularzWlasciciela implements OnChanges {
  @Input() reset: boolean;
  @Output() notify = new EventEmitter();
  private formularzWyszukiwarki;
  private formularzWlasciciela: FormGroup;
  private wlasciciel: Wlasciciel;

  constructor(private fb: FormBuilder,
              private service: StarostaService) {
    this.formularzWlasciciela = fb.group({
      'imie': [null, [Validators.required, NameValidator.patternValidator]],
      'nazwisko': [null, [Validators.required, LastnameValidator.patternValidator]],
      'ulica': [null, [Validators.required, StreetValidator.patternValidator]],
      'nr_domu': [null, [Validators.required, HousenumberValidator.patternValidator]],
      'kod_pocztowy': [null, [Validators.required, PostcodeValidator.patternValidator]],
      'miejscowosc': [null, [Validators.required, TownValidator.patternValidator]],
      'pesel': [null, [Validators.required, P_I_NumberValidator.patternValidator]]
    });

    this.formularzWyszukiwarki = fb.group({
      'search': [null, [Validators.required, P_I_NumberValidator.patternValidator]]
    });

    this.formularzWlasciciela.valueChanges.subscribe(() => {
      this.notify.emit(this.formularzWlasciciela);
    });
  }

  isOwnerExists(pesel: string) {
    this.wlasciciel = new Wlasciciel(null, null, null, null, null, null, null);
    this.formularzWlasciciela.reset();
    this.formularzWyszukiwarki.reset();
    this.service.getOwner(pesel).subscribe(
      wlasciciel => {
        this.wlasciciel = wlasciciel;
      },
      error => {
        console.log(error);
      }
    );
    // this.wlasciciel = new Wlasciciel('John', 'Doe-Ave', 'Kocia', '3', '03-028', 'Warszawa', '75120514389');
  }

  ngOnChanges(changes: SimpleChanges) {
    if (this.reset) {
      this.formularzWlasciciela.reset();
      this.wlasciciel = new Wlasciciel(null, null, null, null, null, null, null);
    }
    if (!this.wlasciciel) {
      this.wlasciciel = new Wlasciciel(null, null, null, null, null, null, null);
    }
  }
}
