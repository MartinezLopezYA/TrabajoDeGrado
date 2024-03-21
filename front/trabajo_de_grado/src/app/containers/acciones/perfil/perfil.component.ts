import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { FormPerfilComponent } from './modal/form-perfil/form-perfil.component';


export interface DialogData {
  animal: string;
  name: string;
}
@Component({
  selector: 'app-perfil',
  templateUrl: './perfil.component.html',
  styleUrls: ['./perfil.component.css'],
})
export class PerfilComponent implements OnInit{

  animal: string | undefined;
  name: string | undefined;

  constructor(public dialog: MatDialog){}

  ngOnInit(): void {
  }

  editarInformacion() {
    let df = this.dialog.open(FormPerfilComponent, {
      data: { name: this.name, animal: this.animal },
      width: '700px',
      height: '500px'
    });
    df.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      this.animal = result;
    });
  }
  
}
