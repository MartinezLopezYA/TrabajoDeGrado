import { Component } from '@angular/core';

@Component({
  selector: 'app-perfil',
  templateUrl: './perfil.component.html',
  styleUrls: ['./perfil.component.css']
})
export class PerfilComponent {

  constructor(){}

  usuario = 'Andres Martinez';
  correoInstitucionl = 'andres@uniminuto.edu.co';
  semestreActual = 'Décimo';
  documento = 1010110;

}
