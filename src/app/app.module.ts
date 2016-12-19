import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import {AppRoutingModule} from "./app-routing.module";
import {Starosta} from "./components/startosta/starosta.component";
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {RejestracjaSamochodu} from "./components/startosta/rejestracja-samochodu/rejestracja-samochodu.component";
import {AutoService} from "./_services/auto.service";

@NgModule({
  declarations: [
    AppComponent,
    Starosta,
    RejestracjaSamochodu
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpModule,
    AppRoutingModule,
    NgbModule.forRoot()
  ],
  providers: [AutoService],
  bootstrap: [AppComponent]
})
export class AppModule { }
