import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  ingresar(obj:any):boolean {

    return ((obj.email === "helmer.rodriguez@uniminuto.edu.co" && obj.password === "123456") || (obj.email === "andres.martinez@uniminuto.edu.co" && obj.password === "456789"));

  }
}
