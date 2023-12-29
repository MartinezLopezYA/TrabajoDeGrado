import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, delay, map, of } from 'rxjs';
import { API_URL_BACK } from 'src/environments/endpoints';
import { RegistroUsuario } from '../interfaces/usuario';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  spcificEndPoint = API_URL_BACK + '/usuario';
  usuarioEncontrado: RegistroUsuario | null = null;

  constructor(
    private http: HttpClient
  ) { }


  getUsers(): Observable<RegistroUsuario[]> {
    return this.http.get<RegistroUsuario[]>(this.spcificEndPoint +`/listausuarios`);
  }

  login(correo: string, contrasena: string): Observable<boolean> {
    return this.getUsers().pipe(
      delay(1000),
      map((users) => {
        const usuarioEncontrado = users.find(
          (usuario) => usuario.correoUsuario === correo && usuario.contrasena === contrasena
        );
        if (usuarioEncontrado) {
          this.usuarioEncontrado = usuarioEncontrado;
          return true;
        } else {
          return false;
        }
      })
    );
  }

}
