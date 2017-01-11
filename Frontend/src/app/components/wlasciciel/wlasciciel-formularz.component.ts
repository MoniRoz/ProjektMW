import {Component, EventEmitter, Output, Input, OnChanges, SimpleChanges} from '@angular/core';
import {FormGroup, FormBuilder, Validators, Validator} from "@angular/forms";
import {Wlasciciel} from "../../_mocks/wlasciciel";
import {StarostaService} from "../../_services/starosta.service";

@Component({
  selector: 'wlasciciel-formularz',
  templateUrl: 'wlasciciel-formularz.component.html'
})
export class FormularzWlasciciela implements OnChanges {
  @Input() reset: boolean;
  @Output() notify = new EventEmitter();

  private formularzWlasciciela: FormGroup;
  // private wlasciciel: Wlasciciel = new Wlasciciel('John', 'Doe-Ave', 'Kocia', '3', '03-028', 'Warszawa', '75120514389');
  private wlasciciel: Wlasciciel;

  constructor(private fb: FormBuilder,
              private service: StarostaService) {
    this.formularzWlasciciela = fb.group({
      'imie': [null, [Validators.required, Validators.pattern('^[A-ZŁŻ][a-ząćęłńóśźżĄĘŁŃÓŚŹŻ]{1,20}$')]],
      'nazwisko': [null, [Validators.required, Validators.pattern('^[A-ZĆŁŚŻŹ][a-ząćęłńóśźżĄĘŁŃÓŚŹŻ]{1,20}((-|\\s)?[A-ZĆŁŚŻŹ][a-ząćęłńóśźżĄĘŁŃÓŚŹŻ]{1,20})?$')]],
      'ulica': [null, [Validators.required, Validators.pattern('^[A-ZŁŻ][a-ząćęłńóśźżĄĘŁŃÓŚŹŻ]{1,20}$')]],
      'nr_domu': [null, [Validators.required, Validators.pattern('^[0-9]{1,3}[a-z]?$')]],
      'kod_pocztowy': [null, [Validators.required, Validators.pattern('^[0-9]{2}-[0-9]{3}$')]],
      'miejscowosc': [null, [Validators.required, Validators.pattern('^[A-ZĆŁŚŻŹ][a-ząćęłńóśźżĄĘŁŃÓŚŹŻ]{1,20}((-|\\s)?[A-ZĆŁŚŻŹ][a-ząćęłńóśźżĄĘŁŃÓŚŹŻ]{1,20})?$')]],
      'pesel': [null, [Validators.required, Validators.pattern('^\\d{11}$')]]
    });

    this.formularzWlasciciela.valueChanges.subscribe(() => {
      this.notify.emit(this.formularzWlasciciela);
    });
  }

  check(value: any) {
    console.log(value);
  }

  isOwnerExists(value: any) {
    console.log(value);
    this.service.getOwner().subscribe(
      wlasciciel => {
        this.wlasciciel = wlasciciel;
      },
      error => {
        console.log(error);
      }
    )
  }

  ngOnChanges(changes: SimpleChanges) {
    if (this.reset) {
      this.formularzWlasciciela.reset();
    }
    if (!this.wlasciciel) {
      this.wlasciciel = new Wlasciciel(null, null, null, null, null, null, null);
    }
  }
}
