import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { LoginService } from 'src/app/services/login.service';
import { FormPerfilComponent } from './modal/form-perfil/form-perfil.component';

@Component({
  selector: 'app-perfil',
  templateUrl: './perfil.component.html',
  styleUrls: ['./perfil.component.css']
})
export class PerfilComponent implements OnInit{

  constructor(
    private service: LoginService,
    private dialog: MatDialog
  ){}

  ngOnInit(): void {
  }


  get usuarioAutenticado(){
    return this.service.usuarioEncontrado;
  }

  editarInformacion(): void {
    const dialogRef = this.dialog.open(FormPerfilComponent, {
      data: { usuario: this.usuarioAutenticado }, 
    });

    dialogRef.afterClosed().subscribe((result) => {
      if (result) {
        console.log('Información editada con éxito:', result);
      } else {
        console.log('Edición cancelada');
      }
    });
  }

}
