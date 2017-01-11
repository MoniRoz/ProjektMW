import {Injectable} from '@angular/core';
import {Http} from '@angular/http';

import {Observable} from "rxjs";
import {Samochod} from "../_mocks/samochod";
import {Wlasciciel} from "../_mocks/wlasciciel";

@Injectable()
export class AutoService {
  private httpregistrationUrl = 'api/starosta_samochod';

  constructor(private http: Http) {
  }

  nowySamochod(samochod: Samochod, wlasciciel: Wlasciciel) {
    let body = JSON.stringify({'Samochod': samochod, 'Wlasciciel': wlasciciel});
    console.log(body);
    return this.http.post(this.httpregistrationUrl, body)
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
