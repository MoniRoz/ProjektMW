import {Component, EventEmitter, Output, Input, OnChanges, SimpleChanges} from '@angular/core';
import {FormGroup, FormBuilder, Validators, Validator} from "@angular/forms";
import {Wlasciciel} from "../../../_mocks/wlasciciel";
import {StarostaService} from "../../../_services/starosta.service";

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
      'imie': [null, [Validators.required, Validators.pattern('^[A-ZŁŻ][a-ząćęłńóśźżĄĘŁŃÓŚŹŻ]{1,20}$')]],
      'nazwisko': [null, [Validators.required, Validators.pattern('^[A-ZĆŁŚŻŹ][a-ząćęłńóśźżĄĘŁŃÓŚŹŻ]{1,20}((-|\\s)?[A-ZĆŁŚŻŹ][a-ząćęłńóśźżĄĘŁŃÓŚŹŻ]{1,20})?$')]],
      'ulica': [null, [Validators.required, Validators.pattern('^[A-ZĆŁŚŻŹ]{1,}[a-ząćęłńóśźżĄĘŁŃÓŚŹŻ]{0,20}((-|\\s)[A-ZĆŁŚŻŹ]{1,}[a-ząćęłńóśźżĄĘŁŃÓŚŹŻ]{0,20}){0,5}')]],
      'nr_domu': [null, [Validators.required, Validators.pattern('^[0-9]{1,3}[a-z]?$')]],
      'kod_pocztowy': [null, [Validators.required, Validators.pattern('^[0-9]{2}-[0-9]{3}$')]],
      'miejscowosc': [null, [Validators.required, Validators.pattern('^[A-ZĆŁŚŻŹ][a-ząćęłńóśźżĄĘŁŃÓŚŹŻ]{1,20}((-|\\s)?[A-ZĆŁŚŻŹ][a-ząćęłńóśźżĄĘŁŃÓŚŹŻ]{1,20})?$')]],
      'pesel': [null, [Validators.required, Validators.pattern('^\\d{11}$')]]
    });

    this.formularzWyszukiwarki = fb.group({
      'search': [null, [Validators.required, Validators.pattern('^\\d{11}$')]]
    });

    this.formularzWlasciciela.valueChanges.subscribe(() => {
      this.notify.emit(this.formularzWlasciciela);
    });
  }

  isOwnerExists(pesel: string) {
    this.service.getOwner(pesel).subscribe(
      wlasciciel => {
        this.wlasciciel = wlasciciel;
      },
      error => {
        console.log(error);
      }
    );
    this.formularzWyszukiwarki.reset();
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
