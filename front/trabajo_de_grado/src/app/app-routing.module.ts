import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './containers/login/login.component';
import { SinginComponent } from './containers/singin/singin.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent},
  { path: 'singin', component: SinginComponent},

  { path: '', redirectTo: '/login', pathMatch: 'full'},

]; 

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
