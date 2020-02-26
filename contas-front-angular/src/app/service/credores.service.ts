import { Globals } from 'src/app/globals';
import { HttpClient } from '@angular/common/http';
import { GenericService } from './generic.service';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CredoresService extends GenericService<Credor>{

  constructor(protected http: HttpClient, private globals: Globals) {
    super(http, globals.apiCredor);
  }
}
