import { CredorEditComponent } from './components/credor/edit/edit.component';
import { CredorAddComponent } from './components/credor/add/add.component';
import { CredorListComponent } from './components/credor/list/list.component';
import { ContasEditComponent } from './components/contas/contas-edit/contas-edit.component';
import { ContasAddComponent } from './components/contas/contas-add/contas-add.component';
import { ContasListComponent } from './components/contas/contas-list/contas-list.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  {    path: "", component: ContasListComponent   },
  {    path: "contas-add", component: ContasAddComponent   },
  {    path: "contas-edit/:id", component: ContasEditComponent   },
  {    path: "credor-list", component: CredorListComponent   },
  {    path: "credor-add", component: CredorAddComponent   },
  {    path: "credor-edit/:id", component: CredorEditComponent   },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
