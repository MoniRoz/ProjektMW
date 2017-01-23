import {Component, Output, EventEmitter} from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {Przeglad} from "../../../_mocks/przeglad";
import {DofIValidator} from "../../../_validators/date-of-issue.validator";
import {EDateValidator} from "../../../_validators/expiry-date.validator";
import {IServicingValidator} from "../../../_validators/issuing-servicing.validator";

@Component({
  selector: 'nowy-przeglad',
  templateUrl: './nowy-przeglad.component.html'
})
export class NowyPrzeglad {
  @Output() notify = new EventEmitter();
  private formularzPrzegladu: FormGroup;

  constructor(private fb: FormBuilder) {
    this.formularzPrzegladu = fb.group({
      'd_wystawienia': [null, DofIValidator.patternValidator],
      'd_waznosci': [null, EDateValidator.patternValidator],
      'wystawiajacy': [null, IServicingValidator.patternValidator]
    });
  }

  submit(value: Przeglad) {
    this.formularzPrzegladu.reset();
    this.notify.emit(value);
  }

}
