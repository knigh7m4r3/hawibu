import { TestBed } from '@angular/core/testing';

import { PostenService } from './posten.service';

describe('PostenService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: PostenService = TestBed.get(PostenService);
    expect(service).toBeTruthy();
  });
});
