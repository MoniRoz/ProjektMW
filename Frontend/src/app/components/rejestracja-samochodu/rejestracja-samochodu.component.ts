import {Component, Output, EventEmitter, Input, SimpleChanges, OnChanges} from '@angular/core';
import {FormGroup, FormBuilder, Validators} from "@angular/forms";

@Component({
  selector: 'rejestracja-samochodu',
  templateUrl: 'rejestracja-samochodu.component.html'
})
export class RejestracjaSamochodu implements OnChanges{
  @Input() reset: boolean;
  @Output() notify = new EventEmitter();
  formularzRejestracji: FormGroup;

  constructor(private fb: FormBuilder) {
    this.formularzRejestracji = fb.group({
      'rodzaj_pojazdu': [null, [Validators.required,Validators.pattern('[a-zA-Z]*')]],
      'marka': [null, [Validators.required,Validators.pattern('[a-zA-Z]*')]],
      'typ': [null, [Validators.required,Validators.pattern('[a-zA-Z]*')]],
      'model': [null, [Validators.required,Validators.pattern('[a-zA-Z]*')]],
      'rok_produkcji': [null, [Validators.required,Validators.minLength(4), Validators.pattern('[0-9]{4,4}')]],
      'nr_VIN': [null, [Validators.required,Validators.pattern('[A-Z0-9]*')]],
      'nr_silnika': [null, [Validators.required,Validators.pattern('[A-Z0-9]*')]],
      'd_nr_rejestracyjny': [null, [Validators.required,Validators.pattern('[A-Z0-9]*')]],
      'nr_kart_pojazdu': [null, [Validators.required,Validators.pattern('[0-9]*')]],
      'przebieg_p_w_km': [null, [Validators.required,Validators.pattern('[0-9]*')]],
      'barwa_nadwozia': [null, [Validators.required,Validators.pattern('[a-zA-Z]*')]]
    });

    this.formularzRejestracji.valueChanges.subscribe(() => {
      this.notify.emit(this.formularzRejestracji);
    });
  }

  ngOnChanges(changes: SimpleChanges) {
    if (this.reset) {
      this.formularzRejestracji.reset();
    }
  }
}
