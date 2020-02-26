import { ContasService } from './service/contas.service';
import { CredoresService } from './service/credores.service';
import { CredorEditComponent } from './components/credor/edit/edit.component';
import { CredorAddComponent } from './components/credor/add/add.component';
import { CredorListComponent } from './components/credor/list/list.component';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ContasListComponent } from './components/contas/contas-list/contas-list.component';
import { ContasAddComponent } from './components/contas/contas-add/contas-add.component';
import { ContasEditComponent } from './components/contas/contas-edit/contas-edit.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    CredorListComponent,
    CredorAddComponent,
    CredorEditComponent,
    ContasListComponent,
    ContasAddComponent,
    ContasEditComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [CredoresService,  ContasService],
  bootstrap: [AppComponent]
})
export class AppModule { }
