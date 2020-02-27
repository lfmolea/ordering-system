import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LoginComponent} from "./login/login.component";
import {AddUserComponent} from "./user/add-user/add-user.component";
import {ListUserComponent} from "./user/list-user/list-user.component";
import {EditUserComponent} from "./user/edit-user/edit-user.component";
import {AddProductComponent} from "./product/add-product/add-product.component";
import {ListProductComponent} from "./product/list-product/list-product.component";
import {EditProductComponent} from "./product/edit-product/edit-product.component";

const routes: Routes = [
{ path: 'login', component: LoginComponent },
{ path: 'add-user', component: AddUserComponent },
{ path: 'list-user', component: ListUserComponent },
{ path: 'edit-user', component: EditUserComponent },
{ path: 'edit-product', component: EditProductComponent },
{ path: 'add-product', component: AddProductComponent },
{ path: 'products', component: ListProductComponent },
{path: '', redirectTo: 'products', pathMatch: 'full'}

];

@NgModule({
imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
