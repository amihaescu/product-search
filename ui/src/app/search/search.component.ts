import { Component, OnInit } from '@angular/core';
import {debounceTime, distinctUntilChanged, map, switchMap} from "rxjs/operators";
import {Observable} from "rxjs";
import {SearchService} from "../search.service";

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.scss']
})
export class SearchComponent implements OnInit {
  public model: any;

  search = (text$: Observable<string>) =>
    text$.pipe(
      debounceTime(200),
      distinctUntilChanged(),
      switchMap( (searchText) =>  this.searchService.find(searchText) )
    );
  formatter  = (result: any) => {
    return result.title + " - $" + result.price;
  };

  constructor(private searchService: SearchService) { }

  ngOnInit() {
  }

}
