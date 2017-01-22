import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';

import {AppComponent} from './app.component';
import {AppRoutingModule} from "./app-routing.module";
import {Starosta} from "./components/startosta/starosta.component";
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {RejestracjaSamochodu} from "./components/startosta/rejestracja-samochodu/rejestracja-samochodu.component";
import {AutoService} from "./_services/auto.service";
import {FormularzWlasciciela} from "./components/startosta/wlasciciel/wlasciciel-formularz.component";
import {Policjant} from "./components/policjant/policjant.component";
import {StarostaService} from "./_services/starosta.service";
import {WlascicielInfo} from "./components/policjant/wlascicele-informacje/wlasciciel-informacje.component";
import {Ng2TableModule} from "ng2-table";
import {PojazdInfo} from "./components/policjant/pojazd-informacje/pojazd-informacje.component";
import { PaginationModule } from 'ng2-bootstrap/pagination';
import {SKP} from "./components/skp/skp.component";
import {PrzegladInfo} from "./components/policjant/przeglad-informacje/przeglad-informacje.component";

@NgModule({
  declarations: [
    AppComponent,
    Starosta,
    Policjant,
    RejestracjaSamochodu,
    FormularzWlasciciela,
    WlascicielInfo,
    PojazdInfo,
    SKP,
    PrzegladInfo
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpModule,
    AppRoutingModule,
    Ng2TableModule,
    NgbModule.forRoot(),
    PaginationModule.forRoot()
  ],
  providers: [AutoService, StarostaService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
