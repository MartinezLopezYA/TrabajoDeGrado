import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { RegistroUsuario, RegistroUsuarioActualizar } from '../interfaces/usuario';
import { Observable } from 'rxjs';
import { API_URL_BACK } from 'src/environments/endpoints';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  spcificEndPoint = API_URL_BACK + '/usuario';

  constructor(
    private http: HttpClient

  ) { }

  registarUsuarioService(usuario: RegistroUsuario): Observable<RegistroUsuario> {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
      }),
    };
    return this.http.post<RegistroUsuario>(this.spcificEndPoint + `/registrarusuario`, usuario, httpOptions);
  }

  editarUsuario(idUsuario: number, usuario: RegistroUsuario): Observable<RegistroUsuarioActualizar> {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
      }),
    };
    return this.http.put<RegistroUsuarioActualizar>(this.spcificEndPoint + `/editarusuario/${idUsuario}`, usuario, httpOptions);
  }

}
