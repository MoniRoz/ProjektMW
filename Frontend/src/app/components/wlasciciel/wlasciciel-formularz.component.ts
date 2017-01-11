import {Component, EventEmitter, Output, Input, OnChanges, SimpleChanges} from '@angular/core';
import {FormGroup, FormBuilder, Validators} from "@angular/forms";
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
  // private wlasciciel: Wlasciciel = new Wlasciciel('John', 'Doe', 'Kocia 11', '3', '03-028', 'Warszawa', '75120514389');
  private wlasciciel: Wlasciciel;

  constructor(private fb: FormBuilder,
              private service: StarostaService) {
    this.formularzWlasciciela = fb.group({
      'imie': [null, [Validators.required, Validators.pattern('[a-zA-Z]*')]],
      'nazwisko': [null, [Validators.required, Validators.pattern('[a-zA-Z]*')]],
      'ulica': [null],
      'nr_domu': [null],
      'kod_pocztowy': [null],
      'miejscowosc': [null],
      'pesel': [null]
    });

    this.formularzWlasciciela.valueChanges.subscribe(() => {
      this.notify.emit(this.formularzWlasciciela);
    });
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
