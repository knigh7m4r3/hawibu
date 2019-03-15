import { TestBed } from '@angular/core/testing';

import { MonatService } from './monat.service';

describe('MonatService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: MonatService = TestBed.get(MonatService);
    expect(service).toBeTruthy();
  });
});
