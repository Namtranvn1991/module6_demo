import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {Medical} from '../model/medical';
import {Patient} from '../model/patient';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {
  private url = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  getAll(page: number): Observable<Medical[]>{
    return this.http.get<Medical[]>(this.url + '?page=' + page);
  }

  getById(id: string): Observable<Medical>{
    return this.http.get<Medical>(this.url + '/' + id);
  }

  edit(medical: Medical): Observable<Medical>{
    return this.http.put<Medical>(this.url, medical);
  }

  delete(id: string): Observable<Medical>{
    return this.http.delete<Medical>(this.url + '/' + id);
  }

}
