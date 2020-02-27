import { BrowserModule } from '@angular/platform-browser';
import { NgModule} from '@angular/core';
import { Interceptors } from './interceptors';
import { ReactiveFormsModule,FormsModule } from '@angular/forms';
import { Component } from '@angular/core';
import { Pipe, PipeTransform } from '@angular/core';
import { Directive } from '@angular/core';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { ListUserComponent } from './user/list-user/list-user.component';
import { AddUserComponent } from './user/add-user/add-user.component';
import { EditUserComponent } from './user/edit-user/edit-user.component';
import { ApiService } from './services/api.service';
import { ProductService } from './services/product.service';
import { AddProductComponent } from './product/add-product/add-product.component';
import { ListProductComponent } from './product/list-product/list-product.component';
import { EditProductComponent } from './product/edit-product/edit-product.component';


@NgModule({
declarations: [
AppComponent,
LoginComponent,
ListUserComponent,
AddUserComponent,
EditUserComponent,
AddProductComponent,
ListProductComponent,
EditProductComponent,
],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [ApiService,ProductService
],
  bootstrap: [AppComponent]
})
export class AppModule { }
