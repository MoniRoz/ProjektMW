import {Component} from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import * as $ from 'jquery';
import {Przeglad} from "../../../_mocks/przeglad";

@Component({
  selector: 'nowy-przeglad',
  templateUrl: './nowy-przeglad.component.html'
  // styleUrls: ['../_css/app.component.css']
})
export class NowyPrzeglad {
  private formularzPrzegladu: FormGroup;

  constructor(private fb: FormBuilder) {
    this.formularzPrzegladu = fb.group({
      'd_wystawienia': [null],
      'd_waznosci': [null],
      'wystawiajacy': [null]
    });
  }

  submit(value: Przeglad) {
    this.formularzPrzegladu.reset();
    console.log(value);
  }

}
