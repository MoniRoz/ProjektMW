import {NgModule}             from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {Starosta} from "./components/startosta/starosta.component";
import {Policjant} from "./components/policjant/policjant.component";
import {SKP} from "./components/skp/skp.component";

const routes: Routes = [
  {path: '', redirectTo: 'starostwo', pathMatch: 'full'},
  {path: 'starostwo', component: Starosta},
  {path: 'policja', component: Policjant},
  {path: 'skp', component: SKP}

];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
