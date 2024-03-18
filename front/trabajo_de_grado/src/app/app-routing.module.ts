import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './containers/auth/login/login.component';
import { SinginComponent } from './containers/auth/singin/singin.component';
import { PerfilComponent } from './containers/acciones/perfil/perfil.component';
import { InicioComponent } from './containers/acciones/inicio/inicio.component';
import { RecursosComponent } from './containers/acciones/recursos/recursos.component';
import { CursoPythonComponent } from './containers/cursos/curso-python/curso-python.component';
import { QuicesComponent } from './containers/acciones/quices/quices.component';
import { InsigniasComponent } from './containers/acciones/insignias/insignias.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent},
  { path: 'singin', component: SinginComponent},
  { path: 'inicio', component: InicioComponent},
  { path: 'quices', component: QuicesComponent},
  { path: 'perfil', component: PerfilComponent},
  { path: 'recursos', component: RecursosComponent},
  { path: 'insignias', component: InsigniasComponent},
  { path: 'curso-python', component: CursoPythonComponent},


  { path: '', redirectTo: '/inicio', pathMatch: 'full'},

]; 

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
