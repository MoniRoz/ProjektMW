import {Component, EventEmitter, Output, Input, OnChanges, SimpleChanges} from '@angular/core';
import {FormGroup, FormBuilder, Validators} from "@angular/forms";

@Component({
  selector: 'wlasciciel-formularz',
  templateUrl: 'wlasciciel-formularz.component.html'
})
export class FormularzWlasciciela implements OnChanges {
  @Input() reset: boolean;
  @Output() notify = new EventEmitter();

  private formularzWlasciciela: FormGroup;

  constructor(private fb: FormBuilder) {
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

  ngOnChanges(changes: SimpleChanges) {
    if (this.reset) {
      this.formularzWlasciciela.reset();
    }
  }

}
