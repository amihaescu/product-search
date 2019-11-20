import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {AuthenticationService} from "../authentication.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  userName: FormControl;
  password: FormControl;
  form: FormGroup;

  constructor(private authService: AuthenticationService, private router: Router) {
    this.userName = new FormControl('', Validators.required);
    this.password = new FormControl('', Validators.required);
    this.form = new FormGroup({
      userName : this.userName,
      password: this.password
    });
  }

  ngOnInit() {
  }

  login() {
    this.authService.authenticate(this.form.getRawValue()).subscribe(
      () => {
        this.router.navigate(['search']);
      });
  }


}
