import { TestBed } from '@angular/core/testing';

import { CredoresService } from './credores.service';

describe('CredoresService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CredoresService = TestBed.get(CredoresService);
    expect(service).toBeTruthy();
  });
});
