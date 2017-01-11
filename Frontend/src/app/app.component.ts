import {Component, AfterViewInit} from '@angular/core';
import * as $ from 'jquery';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['../_css/app.component.css']
})
export class AppComponent implements AfterViewInit{
  title = 'CEPiK';

  ngAfterViewInit() {
    $('.nav-tab.nav-item').click(function () {
      $('.nav-tab.nav-item.active').removeClass('active');
      $(this).addClass('active');
    });
  }

}
