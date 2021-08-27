import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class TestService  {
  constructor(protected _http: HttpClient) {
  }
  getTestAdminMessage():Observable<any>{
    return this._http.get<any>("http://localhost:8888/api/demo");
  }
  getTestManagerMessage():Observable<any>{
    return this._http.get<any>("http://localhost:8888/api/manager");
  }
}
