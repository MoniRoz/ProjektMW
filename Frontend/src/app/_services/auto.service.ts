import {Injectable} from '@angular/core';
import {Http, URLSearchParams, Response} from '@angular/http';

import {Observable} from "rxjs";
import {Samochod} from "../_mocks/samochod";
import {Wlasciciel} from "../_mocks/wlasciciel";
import {Przeglad} from "../_mocks/przeglad";

@Injectable()
export class AutoService {
  private httpregistrationUrl = 'api/starosta_samochod';
  private httpFindCars = 'api/policjant/samochody';
  private httpFindOwners = 'api/policjant/wlasciciele';
  private httpFindPrzeglad = 'api/policjant/przeglady';
  private httpNowyPrzeglad = 'api/skp/samochod_przeglad';

  constructor(private http: Http) {
  }

  nowySamochod(samochod: Samochod, wlasciciel: Wlasciciel) {
    let body = JSON.stringify({'samochod': samochod, 'wlasciciel': wlasciciel});
    return this.http.post(this.httpregistrationUrl, body)
      .map((res: Response) => {
        if (res.status === 200)
          return 200;
      })
      .catch(this.handleError);
  }

  nowyPrzeglad(vin: string, przeglad: Przeglad) {
    let body = JSON.stringify({'vin': vin, 'przeglad': przeglad});
    return this.http.post(this.httpNowyPrzeglad, body)
      .map(res => res.json())
      .catch(this.handleError);
  }

  znajdzSamochody(value: string): Observable <Samochod[]> {
    let params = new URLSearchParams();
    params.set('wartosc', value);
    return this.http.get(this.httpFindCars, {search: params})
      .map(res => res.json())
      .catch(this.handleError);
  }

  znajdzWlascicieli(samochod: Samochod) {
    let params = new URLSearchParams();
    params.set('vin', samochod.nr_VIN);
    return this.http.get(this.httpFindOwners, {search: params})
      .map(res => res.json())
      .catch(this.handleError);
  }

  znajdzPrzeglady(samochod: Samochod) {
    let params = new URLSearchParams();
    params.set('vin', samochod.nr_VIN);
    return this.http.get(this.httpFindPrzeglad, {search: params})
      .map(res => res.json())
      .catch(this.handleError);
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
