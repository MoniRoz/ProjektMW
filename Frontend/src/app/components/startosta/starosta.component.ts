import {Component, AfterViewInit} from '@angular/core';
import {AutoService} from "../../_services/auto.service";
import * as $ from 'jquery';

@Component({
  selector: 'starosta',
  templateUrl: 'starosta.component.html'
})
export class Starosta implements AfterViewInit {
  private wlascicielFormularz: any = '';
  private samochodFormularz: any = '';
  private reset: boolean = false;
  message: string;

  constructor(private autoService: AutoService) {

  }

  ngAfterViewInit() {
    $('.tab.nav-link').click(function () {
      $('.nav-link.active').removeClass('active');
      $(this).addClass('active');
    });
  }

  isFormValid() {
    if (this.wlascicielFormularz.valid && this.samochodFormularz.valid) {
      return true;
    } else {
      return false;
    }
  }

  submit() {
    this.autoService.nowySamochod(this.samochodFormularz.value).subscribe(
      data => {
        console.log('Data: ' + data);
        this.message = 'Rejestracja przebiegła pomyślnie';
      },
      error => {
        this.message = error;
      });
    console.log(this.samochodFormularz.value);
    this.reset = true;
    setTimeout(() => {
      this.reset = false;
    });
  }
}
