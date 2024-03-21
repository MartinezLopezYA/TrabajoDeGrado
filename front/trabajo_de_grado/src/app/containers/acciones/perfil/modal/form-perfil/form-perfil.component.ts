import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { DialogData } from '../../perfil.component';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-form-perfil',
  templateUrl: './form-perfil.component.html',
  styleUrls: ['./form-perfil.component.css'],
})
export class FormPerfilComponent implements OnInit {
  myForm!: FormGroup;

  constructor(public df: MatDialogRef<FormPerfilComponent>,
    @Inject(MAT_DIALOG_DATA) public data: DialogData,) { }

  ngOnInit(): void {
    this.myForm = new FormGroup({
      idUsuario: new FormControl('000', [Validators.required]),
      nomUsuario: new FormControl('Andres'),
      apeUsuario: new FormControl('Martinez'),
      semUsuario: new FormControl('10'),
      emaUsuario: new FormControl('yerson.martinez-l@uniminuto.edu.co'),
      fnaUsuario: new FormControl(''),
    });
  }
  
  guardarEdicion(){

  }
  
  cancelarEdicion(): void {
    this.df.close();
  }

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

}