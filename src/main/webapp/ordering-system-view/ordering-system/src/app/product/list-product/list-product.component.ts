import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {Product} from "../../model/product";
import {ProductService} from "../../services/product.service";

@Component({
  selector: 'app-list-product',
  templateUrl: './list-product.component.html',
  styleUrls: ['./list-product.component.css']
})
export class ListProductComponent implements OnInit {

products: Product[];

constructor(private router: Router, private productService: ProductService) { }

  ngOnInit() {
this.reloadData();
  }
addProduct(): void {
    this.router.navigate(['add-product']);
  };
reloadData() {
     this.productService.findAll().subscribe(data => {
      this.products = data;
    });
  }

  deleteProduct(id: number) {
    this.productService.deleteProduct(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  productDetails(id: number){
    this.router.navigate(['details', id]);
  }

  updateProduct(id: number){
    this.router.navigate(['update', id]);
  }
}
