import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{

  public myForm!: FormGroup;

  constructor(

    private fb:FormBuilder,
    private loging:LoginService,
    private router:Router

  ){}

  nombreApp = 'MD Tutor';

  ngOnInit():void{ 

    this.myForm = this.inicioSesion()

  }

  inicioSesion():FormGroup{
   return this.fb.group({
    email:['',[Validators.required]],
    password:['',[Validators.required]]
   });
  }

  ingresar(){
    if (this.myForm.invalid){
      Object.values(this.myForm.controls).forEach(control => {
        control.markAllAsTouched();
      });
      return;
    }

    if (!this.loging.ingresar(this.myForm.value)){
      alert('Alumno no Registrado');
    } else {
      this.router.navigate(['/perfil']);
    }
      
  }

  get f():any {
    return this.myForm.controls;
  }

}
