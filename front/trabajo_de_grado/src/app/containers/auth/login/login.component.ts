import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{

  loginForm: FormGroup;

  constructor(
    private fb: FormBuilder, 
    private authService: LoginService,
    private router: Router) {
    this.loginForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required]]
    });
  }

  nombreApp = 'MD Tutor';

  
  ngOnInit():void{ 
  }

  iniciarSesion(): void {
    if (this.loginForm.valid) {
      const email = this.loginForm.get('email')?.value;
      const password = this.loginForm.get('password')?.value;
        this.authService.login(email, password).subscribe(
        (loginExitoso) => {
          if (loginExitoso) {
            console.log('Login exitoso');
            this.router.navigate(['/perfil']);
          } else {
            console.error('Error en el login');
          }
        },
        (error) => {
          console.error('Error en el login', error);
        }
      );
    } else {
      this.loginForm.markAllAsTouched();
    }
  }

}
