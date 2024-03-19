import { Component, OnInit } from '@angular/core';
import { NavigationEnd, Router } from '@angular/router';
import { filter } from 'rxjs/operators';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  
  usuario: string = 'Andres Martinez';
  activo:string = '';

  constructor(
    private service: LoginService,
    private router: Router
  ) {}


  ngOnInit(): void {
    this.tabSeleccionadoNabvar();
  }

  tabSeleccionadoNabvar() {
    // const navLinks = document.querySelectorAll('.nav-link');
    // navLinks.forEach(link => {
    //   link.addEventListener('click', function () {
    //     navLinks.forEach(link => {
    //       link.classList.remove('active');
    //     });
    //     link.classList.add('active');
    //   });
    // });
  }

  get usuarioAutenticado() {
    return this.service.usuarioEncontrado;
  };


}
