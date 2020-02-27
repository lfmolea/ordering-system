import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {ProductService} from "../../services/product.service";

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {
addForm: FormGroup;
constructor(private formBuilder: FormBuilder,private router: Router, private productService: ProductService) { }

  ngOnInit() {
    this.addForm = this.formBuilder.group({
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

  }

  onSubmit() {
    this.productService.addProduct(this.addForm.value)
      .subscribe( data => {
        this.router.navigate(['list-product']);
      });
  }

}

