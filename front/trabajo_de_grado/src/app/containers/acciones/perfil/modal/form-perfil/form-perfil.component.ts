import { Component, Inject } from '@angular/core';

@Component({
  selector: 'app-form-perfil',
  templateUrl: './form-perfil.component.html',
  styleUrls: ['./form-perfil.component.css'],
})
export class FormPerfilComponent {
  // formularioEdicion: FormGroup;

  constructor(){}

  // guardarEdicion(): void {
  //   if (this.formularioEdicion.valid) {
  //     const nuevaInformacion: RegistroUsuario = {
  //       ...this.data.usuario, // Mantiene los valores existentes
  //       nombreUsuario: this.formularioEdicion.get('nombreUsuario')?.value,
  //       apellidoUsuario: this.formularioEdicion.get('apellidoUsuario')?.value,
  //       semestre: this.formularioEdicion.get('semestre')?.value,
  //       fechaNacimiento: this.formularioEdicion.get('fechaNacimiento')?.value,
  //     };
  //     const idUsuario = this.data.usuario.idUsuario; 
  //     this.service.editarUsuario(idUsuario, nuevaInformacion).subscribe(
  //       () => {
  //         this.dialogRef.close(nuevaInformacion);
  //         setTimeout(() => {
  //           this.router.navigate(['/perfil']);
  //         }, 300);
  //       },
  //       (error) => {
  //         console.error('Error al actualizar los datos:', error);
  //       }
  //     );
  //   }
  // }

  // cancelarEdicion(): void {
  //   this.dialogRef.close();
  // }
}