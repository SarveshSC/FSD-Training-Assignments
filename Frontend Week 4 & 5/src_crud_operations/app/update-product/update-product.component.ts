import { Component } from '@angular/core';
import { Product } from '../product/product';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-update-product',
  templateUrl: './update-product.component.html',
  styleUrls: ['./update-product.component.css']
})
export class UpdateProductComponent {

  constructor(private productService:ProductService){

  }

  updateProduct(data : Product){
    console.log(data);
    this.productService.update(data, data.id);
  }
}
