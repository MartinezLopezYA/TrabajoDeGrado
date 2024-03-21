import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { MaterialModule } from './material.module';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './containers/auth/login/login.component';
import { SinginComponent } from './containers/auth/singin/singin.component';
import { PerfilComponent } from './containers/acciones/perfil/perfil.component';
import { InicioComponent } from './containers/acciones/inicio/inicio.component';
import { RecursosComponent } from './containers/acciones/recursos/recursos.component';
import { FormPerfilComponent } from './containers/acciones/perfil/modal/form-perfil/form-perfil.component';
import { NavbarComponent } from './utils/globales/navbar/navbar.component';
import { TestinicialComponent } from './utils/testinicial/testinicial.component';
import { AlertsComponent } from './utils/globales/alerts/alerts.component';

import { CursoPythonComponent } from './containers/cursos/curso-python/curso-python.component';
import { FooterComponent } from './utils/globales/footer/footer.component';
import { QuicesComponent } from './containers/acciones/quices/quices.component';
import { InsigniasComponent } from './containers/acciones/insignias/insignias.component';


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
    CursoPythonComponent,
    FooterComponent,
    QuicesComponent,
    InsigniasComponent,
  ],
  imports: [
    AppRoutingModule, 
    BrowserModule,
    BrowserAnimationsModule,
    MaterialModule,


    //HttpClient
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
