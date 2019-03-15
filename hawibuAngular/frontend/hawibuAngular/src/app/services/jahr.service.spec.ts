import { TestBed } from '@angular/core/testing';

import { JahrService } from './jahr.service';

describe('JahrService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: JahrService = TestBed.get(JahrService);
    expect(service).toBeTruthy();
  });
});
