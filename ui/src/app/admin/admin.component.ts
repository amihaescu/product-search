import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.scss']
})
export class AdminComponent implements OnInit {

  private form: FormGroup;
  private title: FormControl;
  private price: FormControl;
  private description: FormControl;
  private tag: FormControl;
  private image: FormControl;
  private tags: string[] = [];

  constructor() {
    this.title = new FormControl();
    this.price = new FormControl();
    this.description = new FormControl();
    this.tag = new FormControl();
    this.image = new FormControl();
    this.form = new FormGroup({
      title: this.title,
      price: this.price,
      description: this.description,
      tag: this.tag,
      image: this.image
    });
  }

  addTag(): void {
    console.log('got value: ', this.tag.value);
    this.tags.push(this.tag.value);
    this.tag.setValue("");
}


  ngOnInit() {
  }

}
