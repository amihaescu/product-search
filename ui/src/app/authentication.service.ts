import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

class UserPassword {
  username: string;
  password: string;
}

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private http: HttpClient) { }

  authenticate(authenticationData: UserPassword) : Observable<any> {
    console.log('authentication data: ', authenticationData);
    return new Observable<any>();
  }
}
