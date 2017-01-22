import {Component} from '@angular/core';
import {FormBuilder} from "@angular/forms";
import * as $ from 'jquery';

@Component({
  selector: 'skp',
  templateUrl: 'skp.component.html'
})
export class SKP {
  private formularzWyszukiwarki;

  public constructor(private fb: FormBuilder) {
    this.formularzWyszukiwarki = fb.group({
      'search': [null]
    });
  }
}
