import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';

import {AppComponent} from './app.component';
import {AppRoutingModule} from "./app-routing.module";
import {Starosta} from "./components/startosta/starosta.component";
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {RejestracjaSamochodu} from "./components/rejestracja-samochodu/rejestracja-samochodu.component";
import {AutoService} from "./_services/auto.service";
import {FormularzWlasciciela} from "./components/wlasciciel/wlasciciel-formularz.component";
import {Policjant} from "./components/policjant/policjant.component";
import {StarostaService} from "./_services/starosta.service";
import {KartaPojazdu} from "./components/karta_pojazdu/karta_pojazdu.component";

@NgModule({
  declarations: [
    AppComponent,
    Starosta,
    Policjant,
    RejestracjaSamochodu,
    FormularzWlasciciela,
    KartaPojazdu
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpModule,
    AppRoutingModule,
    NgbModule.forRoot()
  ],
  providers: [AutoService, StarostaService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
