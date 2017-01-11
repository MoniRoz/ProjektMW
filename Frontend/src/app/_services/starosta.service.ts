import {Injectable} from '@angular/core';
import {Http} from '@angular/http';

import {Observable} from "rxjs";
import {Samochod} from "../_mocks/samochod";
import {Wlasciciel} from "../_mocks/wlasciciel";
import {error} from "util";
import any = jasmine.any;

@Injectable()
export class StarostaService {
  private httpVehicleDataUrl = 'api/starosta/dane_samochod';
  private httpOwnersDataUrl = 'api/starosta/dane_wlasciciel';

  constructor(private http: Http) {
  }

  getVehicle(): Observable<Samochod> {
    return this.http.get(this.httpVehicleDataUrl).map(res => res.json()).catch(this.handleError);
  }

  getOwner(): Observable<Wlasciciel> {
    return this.http.get(this.httpOwnersDataUrl).map(res => res.json()).catch(this.handleError);
  }

  private handleError(error: any) {
    let errorMsg;
    if (error.status === 500) {
      errorMsg = error.message ||
        error.status + ` Internal Server Error`
    } else {
      errorMsg = error.message ||
        `Oops! Error status: ` + error.status
    }
    // throw an application level error
    return Observable.throw(errorMsg);
  }
}
