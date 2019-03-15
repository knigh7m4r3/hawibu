import { TestBed } from '@angular/core/testing';

import { GeschaeftService } from './geschaeft.service';

describe('GeschaeftService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: GeschaeftService = TestBed.get(GeschaeftService);
    expect(service).toBeTruthy();
  });
});
