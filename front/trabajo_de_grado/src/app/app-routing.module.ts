import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './containers/login/login.component';
import { SinginComponent } from './containers/singin/singin.component';
import { PerfilComponent } from './containers/acciones/perfil/perfil.component';
import { InicioComponent } from './containers/acciones/inicio/inicio.component';
import { RecursosComponent } from './containers/acciones/recursos/recursos.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent},
  { path: 'singin', component: SinginComponent},
  { path: 'perfil', component: PerfilComponent},
  { path: 'inicio', component: InicioComponent},
  { path: 'recursos', component: RecursosComponent},


  { path: '', redirectTo: '/inicio', pathMatch: 'full'},

]; 

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
