import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GenericService<T> {

  constructor(protected http: HttpClient, protected url: string) { }

  getById(id: number): Observable<T> {
    return this.http.get<T>(this.url + '/' + id);
  }

  getList(): Observable<T[]> {
    return this.http.get<T[]>(this.url);
  }
  
  save(entity: T) {
    return this.http.post(this.url, entity);
  }

  edit(id: number, entity: T) {
    return this.http.post(this.url + '/' + id, entity);
  }

  delete(id: number) {
    return this.http.delete(this.url + '/' + id);
  }
  
}
