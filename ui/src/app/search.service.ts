import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {map} from "rxjs/operators";
import {element} from "protractor";

@Injectable({
  providedIn: 'root'
})
export class SearchService {

  private url = 'http://localhost:9200/uploaded/_search';

  constructor(private http: HttpClient) { }

  find(term: string) : Observable<any> {
    return this.http.get(this.url).pipe(map((value: any) => {
      return value.hits.hits.map(value => value._source);
    }));
  }
}
