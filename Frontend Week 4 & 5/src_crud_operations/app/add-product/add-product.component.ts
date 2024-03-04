import { Component } from '@angular/core';
import { Product } from '../product/product';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent {

  constructor(private productService: ProductService){

  }

  addProduct(data : Product){
    this.productService.addProduct(data);
  }
}
