import {Injectable} from '@angular/core';
import {Http} from '@angular/http';

import {Observable} from "rxjs";
import {Samochod} from "../_mocks/samochod";

@Injectable()
export class AutoService {
  private httpLoginUrl = 'api/starosta_samochod';

  constructor(private http: Http) {
  }

  nowySamochod(samochod: Samochod) {
    let body = JSON.stringify(samochod);

    return this.http.post(this.httpLoginUrl, body)
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
