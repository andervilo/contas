import { Injectable } from '@angular/core';
import { GenericService } from './generic.service';
import { Globals } from '../globals';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ContasService extends GenericService<Credor>{

  constructor(protected http: HttpClient, private globals: Globals) {
    super(http, globals.apiContas);
  }
}
