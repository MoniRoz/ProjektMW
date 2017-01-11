import {NgModule}             from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AppComponent} from "./app.component";
import {Starosta} from "./components/startosta/starosta.component";
import {RejestracjaSamochodu} from "./components/rejestracja-samochodu/rejestracja-samochodu.component";
import {FormularzWlasciciela} from "./components/wlasciciel/wlasciciel-formularz.component";
import {Policjant} from "./components/policjant/policjant.component";

const routes: Routes = [
  {path: '', redirectTo: 'starosta', pathMatch: 'full'},
  {path: 'starosta', component: Starosta},
  {path: 'policjant', component: Policjant}
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
