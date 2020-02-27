import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {first} from "rxjs/operators";
import {Product} from "../../model/product";
import {ProductService} from "../../services/product.service";

@Component({
  selector: 'app-edit-product',
  templateUrl: './edit-product.component.html',
  styleUrls: ['./edit-product.component.css']
})
export class EditProductComponent implements OnInit {

product: Product;
editForm: FormGroup;
constructor(private formBuilder: FormBuilder,private router: Router, private productService: ProductService) { }

  ngOnInit() {
    let productId = window.localStorage.getItem("editProductId");
    if(!productId) {
      alert("Invalid action.")
      this.router.navigate(['list-product']);
      return;
    }
    this.editForm = this.formBuilder.group({
      id: [],
      productName: ['', Validators.required],
      type: ['', Validators.required],
      color: ['', Validators.required],
      barcode: ['', Validators.required],
      numberOfItems: ['', Validators.required],
      listPrice: ['', Validators.required],
      ourPrice: ['', Validators.required],
      active: ['', Validators.required]
    });
    this.productService.getProductById(+productId)
      .subscribe( data => {
        this.editForm.setValue(this.product);
      });
  }

  onSubmit() {
    this.productService.updateProduct(this.product)
.subscribe(result => this.gotoProductList());

  }
 gotoProductList() {
    this.router.navigate(['/products']);
  }

}




