import {Component, OnInit} from '@angular/core';
import {Samochod} from "../../_mocks/samochod";
import {FormBuilder} from "@angular/forms";
import * as $ from 'jquery';

@Component({
  selector: 'policjant',
  templateUrl: 'policjant.component.html',
  styleUrls: ['policjant.component.css']
})
export class Policjant implements OnInit {
  private formularzWyszukiwarki;
  // private samochod = new Samochod('Osobowy', 'Ford', 'Sedan', 'Focus', '2008', 'W0L0XCF0814000002', 'F16D3000080K', 'WD70757', 'AWD23423456AAAA', '200000', 'Czerwony');

  public constructor(private fb: FormBuilder) {
    this.formularzWyszukiwarki = fb.group({
      'search': [null]
    });
  }

  ngOnInit(): void {
    $('.loader').hide();
    $('.content').hide();
  }

  private clicked(value: any) {
    this.formularzWyszukiwarki.reset();
    $('#message').hide();
    $('.loader').toggle();
    setTimeout(() => {
      $('.loader').toggle();
      $('.content').fadeIn('slow');
    }, 4000)
  }
}
