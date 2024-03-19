import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { RegistroUsuario } from 'src/app/interfaces/usuario';
import { UsuarioService } from 'src/app/services/usuario.service';

@Component({
  selector: 'app-singin',
  templateUrl: './singin.component.html',
  styleUrls: ['./singin.component.css']
})
export class SinginComponent implements OnInit{

  usuario!: RegistroUsuario;
  myForm!: FormGroup;

  constructor(
    private service: UsuarioService,
    private router: Router,
  ){
  }

  nombreApp = 'MD Tutor';

  ngOnInit(): void {
    this.initForm();
  }

  initForm() {
    this.myForm = new FormGroup({
      idUsuario: new FormControl( Validators.required),
      nombreUsuario: new FormControl(null),
      apellidoUsuario: new FormControl(null),
      correoUsuario: new FormControl(null, [Validators.required, Validators.email]),
      semestre: new FormControl(null, [Validators.required]),
      contrasena: new FormControl(null, [Validators.required]),
      fechaNacimiento: new FormControl(null),
    });
  }

  registroUsuarioFront(){
    if (this.myForm.valid) {
      const usuario: RegistroUsuario = this.myForm.value;
      this.service.registarUsuarioService(usuario).subscribe({
        next: (response) => {
          console.log(response);  // Imprime la respuesta en la consola
          console.log("Usuario registrado exitosamente");
          this.router.navigate(['/login']);
        }
      });
    }
  }
}
