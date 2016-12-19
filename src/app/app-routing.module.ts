import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {AppComponent} from "./app.component";
import {Starosta} from "./components/startosta/starosta.component";

const routes: Routes = [
   { path: '', component: Starosta },
  { path: 'starosta', component:Starosta }
];
@NgModule({
  imports: [ RouterModule.forRoot(routes)],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
