import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './containers/login/login.component';
import { SinginComponent } from './containers/singin/singin.component';
import { PerfilComponent } from './containers/acciones/perfil/perfil.component';
import { InicioComponent } from './containers/acciones/inicio/inicio.component';
import { RecursosComponent } from './containers/acciones/recursos/recursos.component';
import { FormPerfilComponent } from './containers/acciones/perfil/modal/form-perfil/form-perfil.component';
import { NavbarComponent } from './utils/globales/navbar/navbar.component';
import { TestinicialComponent } from './utils/testinicial/testinicial.component';
import { AlertsComponent } from './utils/globales/alerts/alerts.component';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatTabsModule } from '@angular/material/tabs';
import { MatDialogModule } from '@angular/material/dialog';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SinginComponent,
    PerfilComponent,
    InicioComponent,
    RecursosComponent,
    FormPerfilComponent,
    NavbarComponent,
    TestinicialComponent,
    AlertsComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    
    //Angular Material
    BrowserAnimationsModule,
    MatFormFieldModule,
    MatInputModule,
    MatTabsModule,
    MatDialogModule,

    //HttpClient
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
