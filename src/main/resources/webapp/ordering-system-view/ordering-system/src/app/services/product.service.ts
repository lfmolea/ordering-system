import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Product} from "../model/product";
import {Observable} from "rxjs/index";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

private productUrl: string;

constructor(private http: HttpClient) {
    this.productUrl = 'http://localhost:8080/products';
  }

  public findAll(): Observable<Product[]> {
    return this.http.get<Product[]>(this.productUrl);
  }

  public save(product: Product) {
    return this.http.post<Product>(this.productUrl, product);
  }
getProductById(id: number){
    return this.http.get<Product>(this.productUrl + id);
  }

  addProduct(product: Product){
    return this.http.post<Product>(this.productUrl, product);
  }

  updateProduct(product: Product){
    return this.http.put<Product>(this.productUrl + product.id, product);
  }

  deleteProduct(id: number){
    return this.http.delete<Product>(this.productUrl + id);
  }
  getProductList(): Observable<any> {
    return this.http.get(`${this.productUrl}`);
  }
}
