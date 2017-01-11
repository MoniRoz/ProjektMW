/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { AutoService } from './auto.service';

describe('Service: Samochod', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AutoService]
    });
  });

  it('should ...', inject([AutoService], (service: AutoService) => {
    expect(service).toBeTruthy();
  }));
});
