import {Component, AfterViewInit, DoCheck} from '@angular/core';
import {AutoService} from "../../_services/auto.service";
import * as $ from 'jquery';

@Component({
  selector: 'starosta',
  templateUrl: 'starosta.component.html'
})
export class Starosta implements AfterViewInit,DoCheck {
  private wlascicielFormularz: any = '';
  private samochodFormularz: any = '';
  private reset: boolean = false;
  private isValid: boolean = false;
  message: string;

  constructor(private autoService: AutoService) {

  }

  ngAfterViewInit() {
    $('.tab.nav-link').click(function () {
      $('.nav-link.active').removeClass('active');
      $(this).addClass('active');
    });
  }

  ngDoCheck(): void {
    this.isValid = this.isFormValid();
  }

  isFormValid() {
    return (this.wlascicielFormularz.valid && this.samochodFormularz.valid)
  }

  submit() {
    this.message = null;
    this.autoService.nowySamochod(this.samochodFormularz.value, this.wlascicielFormularz.value).subscribe(
      () => {
        this.message = 'Rejestracja przebiegła pomyślnie';
      },
      error => {
        console.log(error);
      });
  //  this.reset = true;
  //  setTimeout(() => {
  //    this.reset = false;
 //   });
  }
}
