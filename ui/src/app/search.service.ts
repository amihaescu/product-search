import { Injectable } from '@angular/core';
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class SearchService {

  constructor() { }

  find(term: string) : Observable<any> {
    return new Observable<any>(subscriber => {
      subscriber.next(['Value 1', 'Value2']);
    });
  }
}
