import { TestBed } from '@angular/core/testing';

import { ArticleBonService } from './article-bon.service';

describe('ArticleBonService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ArticleBonService = TestBed.get(ArticleBonService);
    expect(service).toBeTruthy();
  });
});
