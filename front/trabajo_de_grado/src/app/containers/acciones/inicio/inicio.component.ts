import { Component, OnInit } from '@angular/core';
import {MatDialog, MatDialogModule} from '@angular/material/dialog';
import {MatButtonModule} from '@angular/material/button';
import { TestinicialComponent } from 'src/app/utils/testinicial/testinicial.component';


@Component({
  selector: 'app-inicio',
  templateUrl: './inicio.component.html',
  styleUrls: ['./inicio.component.css']
})
export class InicioComponent implements OnInit{

  constructor(public test: MatDialog){}

  ngOnInit(): void{
    this.testInicial();
  }

  testInicial(){
    const dialogRef = this.test.open(TestinicialComponent);
    dialogRef.afterClosed().subscribe(result => {
      console.log('Test result: ${result}');
    })
  }
}
