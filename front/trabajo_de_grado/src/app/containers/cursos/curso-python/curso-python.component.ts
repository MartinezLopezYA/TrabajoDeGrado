import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-curso-python',
  templateUrl: './curso-python.component.html',
  styleUrls: ['./curso-python.component.css']
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

}
