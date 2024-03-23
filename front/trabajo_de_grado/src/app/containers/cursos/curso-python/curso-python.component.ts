import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-curso-python',
  templateUrl: './curso-python.component.html',
  styleUrls: ['./curso-python.component.css'],
})
export class CursoPythonComponent implements OnInit {

  constructor() {}

  ngOnInit(): void{
    this.tabSeleccionadoNabvar();
  }

  tabSeleccionadoNabvar() {
    const navLinks = document.querySelectorAll('.nav-link');
    navLinks.forEach(link => {
      link.addEventListener('click', function () {
        navLinks.forEach(link => {
          link.classList.remove('active');
        });
        link.classList.add('active');
      });
    });
  }

  mostrarDiv1: boolean = true;
  mostrarDiv2: boolean = false;
  mostrarDiv3: boolean = false;
  mostrarDiv4: boolean = false;
  mostrarDiv5: boolean = false;
  mostrarDiv6: boolean = false;
  mostrarDiv7: boolean = false;
  mostrarDiv8: boolean = false;
  mostrarDiv9: boolean = false;
  mostrarDiv10: boolean = false;
  mostrarDiv11: boolean = false;
  mostrarDiv12: boolean = false;
  mostrarDiv13: boolean = false;
  mostrarDiv14: boolean = false;
  mostrarDiv15: boolean = false;
  mostrarDiv16: boolean = false;
  mostrarDiv17: boolean = false;
  mostrarDiv18: boolean = false;
  mostrarDiv19: boolean = false;

  mostrarSeccion(numeroDiv: number) {
    
    this.mostrarDiv1 = false;
    this.mostrarDiv2 = false;
    this.mostrarDiv3 = false;
    this.mostrarDiv4 = false;
    this.mostrarDiv5 = false;
    this.mostrarDiv6 = false;
    this.mostrarDiv7 = false;
    this.mostrarDiv8 = false;
    this.mostrarDiv9 = false;
    this.mostrarDiv10 = false;
    this.mostrarDiv11 = false;
    this.mostrarDiv12 = false;
    this.mostrarDiv13 = false;
    this.mostrarDiv14 = false;
    this.mostrarDiv15 = false;
    this.mostrarDiv16 = false;
    this.mostrarDiv17 = false;
    this.mostrarDiv18 = false;
    this.mostrarDiv19 = false;

    if (numeroDiv === 1) {
      this.mostrarDiv1 = true;
    } else if (numeroDiv === 2) {
      this.mostrarDiv2 = true;
    } else if (numeroDiv === 3) {
      this.mostrarDiv3 = true;
    } else if (numeroDiv === 4) {
      this.mostrarDiv4 = true;
    } else if (numeroDiv === 5) {
      this.mostrarDiv5 = true;
    } else if (numeroDiv === 6) {
      this.mostrarDiv6 = true;
    } else if (numeroDiv === 7) {
      this.mostrarDiv7 = true;
    } else if (numeroDiv === 8) {
      this.mostrarDiv8 = true;
    } else if (numeroDiv === 9) {
      this.mostrarDiv9 = true;
    } else if (numeroDiv === 10) {
      this.mostrarDiv10 = true;
    } else if (numeroDiv === 11) {
      this.mostrarDiv11 = true;
    } else if (numeroDiv === 12) {
      this.mostrarDiv12 = true;
    } else if (numeroDiv === 13) {
      this.mostrarDiv13 = true;
    } else if (numeroDiv === 14) {
      this.mostrarDiv14 = true;
    } else if (numeroDiv === 15) {
      this.mostrarDiv15 = true;
    } else if (numeroDiv === 16) {
      this.mostrarDiv16 = true;
    } else if (numeroDiv === 17) {
      this.mostrarDiv17 = true;
    } else if (numeroDiv === 18) {
      this.mostrarDiv18 = true;
    } else if (numeroDiv === 19) {
      this.mostrarDiv19 = true;
    }
  }

  siguienteSeccion(){
    if (this.mostrarDiv1) {
      this.mostrarDiv1 = false;
      this.mostrarDiv2 = true;
    } else if (this.mostrarDiv2) {
      this.mostrarDiv2 = false;
      this.mostrarDiv3 = true;
    } else if (this.mostrarDiv3) {
      this.mostrarDiv3 = false;
      this.mostrarDiv4 = true;
    } else if (this.mostrarDiv4) {
      this.mostrarDiv4 = false;
      this.mostrarDiv5 = true;
    } else if (this.mostrarDiv5) {
      this.mostrarDiv5 = false;
      this.mostrarDiv6 = true;
    } else if (this.mostrarDiv6) {
      this.mostrarDiv6 = false;
      this.mostrarDiv7 = true;
    } else if (this.mostrarDiv7) {
      this.mostrarDiv7 = false;
      this.mostrarDiv8 = true;
    } else if (this.mostrarDiv8) {
      this.mostrarDiv8 = false;
      this.mostrarDiv9 = true;
    } else if (this.mostrarDiv9) {
      this.mostrarDiv9 = false;
      this.mostrarDiv10 = true;
    } else if (this.mostrarDiv10) {
      this.mostrarDiv10 = false;
      this.mostrarDiv11 = true;
    } else if (this.mostrarDiv11) {
      this.mostrarDiv11 = false;
      this.mostrarDiv12 = true;
    } else if (this.mostrarDiv12) {
      this.mostrarDiv12 = false;
      this.mostrarDiv13 = true;
    } else if (this.mostrarDiv13) {
      this.mostrarDiv13 = false;
      this.mostrarDiv14 = true;
    } else if (this.mostrarDiv14) {
      this.mostrarDiv14 = false;
      this.mostrarDiv15 = true;
    } else if (this.mostrarDiv15) {
      this.mostrarDiv15 = false;
      this.mostrarDiv16 = true;
    } else if (this.mostrarDiv16) {
      this.mostrarDiv16 = false;
      this.mostrarDiv17 = true;
    } else if (this.mostrarDiv17) {
      this.mostrarDiv17 = false;
      this.mostrarDiv18 = true;
    } else if (this.mostrarDiv18) {
      this.mostrarDiv18 = false;
      this.mostrarDiv19 = true;
    } else if (this.mostrarDiv19) {
      this.mostrarDiv19 = false;
      this.mostrarDiv1 = true;
    } 
  }

  anteriorSeccion(){
    if (this.mostrarDiv1) {
      this.mostrarDiv1 = false;
      this.mostrarDiv19 = true;
    } else if (this.mostrarDiv2) {
      this.mostrarDiv2 = false;
      this.mostrarDiv1 = true;
    } else if (this.mostrarDiv3) {
      this.mostrarDiv3 = false;
      this.mostrarDiv2 = true;
    } else if (this.mostrarDiv4) {
      this.mostrarDiv4 = false;
      this.mostrarDiv3 = true;
    } else if (this.mostrarDiv5) {
      this.mostrarDiv5 = false;
      this.mostrarDiv4 = true;
    } else if (this.mostrarDiv6) {
      this.mostrarDiv6 = false;
      this.mostrarDiv5 = true;
    } else if (this.mostrarDiv7) {
      this.mostrarDiv7 = false;
      this.mostrarDiv6 = true;
    } else if (this.mostrarDiv8) {
      this.mostrarDiv8 = false;
      this.mostrarDiv7 = true;
    } else if (this.mostrarDiv9) {
      this.mostrarDiv9 = false;
      this.mostrarDiv8 = true;
    } else if (this.mostrarDiv10) {
      this.mostrarDiv10 = false;
      this.mostrarDiv9 = true;
    } else if (this.mostrarDiv11) {
      this.mostrarDiv11 = false;
      this.mostrarDiv10 = true;
    } else if (this.mostrarDiv12) {
      this.mostrarDiv12 = false;
      this.mostrarDiv11 = true;
    } else if (this.mostrarDiv13) {
      this.mostrarDiv13 = false;
      this.mostrarDiv12 = true;
    } else if (this.mostrarDiv14) {
      this.mostrarDiv14 = false;
      this.mostrarDiv13 = true;
    } else if (this.mostrarDiv15) {
      this.mostrarDiv15 = false;
      this.mostrarDiv14 = true;
    } else if (this.mostrarDiv16) {
      this.mostrarDiv16 = false;
      this.mostrarDiv15 = true;
    } else if (this.mostrarDiv17) {
      this.mostrarDiv17 = false;
      this.mostrarDiv16 = true;
    } else if (this.mostrarDiv18) {
      this.mostrarDiv18 = false;
      this.mostrarDiv17 = true;
    } else if (this.mostrarDiv19) {
      this.mostrarDiv19 = false;
      this.mostrarDiv18 = true;
    } 
  }

}
