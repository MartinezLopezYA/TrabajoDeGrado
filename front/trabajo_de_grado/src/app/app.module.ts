import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './containers/login/login.component';
import { SinginComponent } from './containers/singin/singin.component';
import { PerfilComponent } from './containers/acciones/perfil/perfil.component';
import { InicioComponent } from './containers/acciones/inicio/inicio.component';
import { RecursosComponent } from './containers/acciones/recursos/recursos.component';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { FormPerfilComponent } from './containers/acciones/perfil/modal/form-perfil/form-perfil.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SinginComponent,
    PerfilComponent,
    InicioComponent,
    RecursosComponent,

    FormPerfilComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    
    
    //Angular Material
    BrowserAnimationsModule,
    MatFormFieldModule,
    MatInputModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
