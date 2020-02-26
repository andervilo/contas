import { Injectable } from '@angular/core';

@Injectable()
export class Globals {
  private root = 'http://localhost:8080/api/v1';
  apiCredor = this.root + '/credores'; 
  apiContas = this.root + '/contas';
}
