import {Component, OnInit} from '@angular/core';
import {FormBuilder} from "@angular/forms";
import * as $ from 'jquery';
import {AutoService} from "../../_services/auto.service";

@Component({
  selector: 'policjant',
  templateUrl: 'policjant.component.html',
  styleUrls: ['policjant.component.css']
})
export class Policjant implements OnInit {
  private formularzWyszukiwarki;

  public constructor(private fb: FormBuilder,
                     private autoService: AutoService) {
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
    this.autoService.znajdzSamochod(value).subscribe(
      data => {
        console.log(data);
      }, error => {
        setTimeout(() => {
          $('.loader').toggle();
          $('.content').fadeIn('slow');
        }, 4000);
      });
  }
}
