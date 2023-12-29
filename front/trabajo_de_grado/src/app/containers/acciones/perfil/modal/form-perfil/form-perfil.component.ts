import { Component, Inject } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { RegistroUsuario } from 'src/app/interfaces/usuario';
import { UsuarioService } from 'src/app/services/usuario.service';

@Component({
  selector: 'app-form-perfil',
  templateUrl: './form-perfil.component.html',
  styleUrls: ['./form-perfil.component.css']
})
export class FormPerfilComponent {
  formularioEdicion: FormGroup;

  constructor(
    private dialogRef: MatDialogRef<FormPerfilComponent>,
    private fb: FormBuilder,
    private service: UsuarioService,
    private router: Router,
    @Inject(MAT_DIALOG_DATA) public data: { usuario: RegistroUsuario }
  ) {
    this.formularioEdicion = this.fb.group({
      // Define tus campos de formulario aquí
      nombreUsuario: [data.usuario.nombreUsuario, Validators.required],
      apellidoUsuario: [data.usuario.apellidoUsuario, Validators.required],
      semestre: [data.usuario.semestre, Validators.required],
      fechaNacimiento: [data.usuario.fechaNacimiento, Validators.required],
      // ... otros campos
    });
  }

  guardarEdicion(): void {
    if (this.formularioEdicion.valid) {
      const nuevaInformacion: RegistroUsuario = {
        ...this.data.usuario, // Mantiene los valores existentes
        nombreUsuario: this.formularioEdicion.get('nombreUsuario')?.value,
        apellidoUsuario: this.formularioEdicion.get('apellidoUsuario')?.value,
        semestre: this.formularioEdicion.get('semestre')?.value,
        fechaNacimiento: this.formularioEdicion.get('fechaNacimiento')?.value,
      };
      const idUsuario = this.data.usuario.idUsuario; 
      this.service.editarUsuario(idUsuario, nuevaInformacion).subscribe(
        () => {
          this.dialogRef.close(nuevaInformacion);
          setTimeout(() => {
            this.router.navigate(['/perfil']);
          }, 300);
        },
        (error) => {
          console.error('Error al actualizar los datos:', error);
        }
      );
    }
  }

  cancelarEdicion(): void {
    this.dialogRef.close();
  }
}