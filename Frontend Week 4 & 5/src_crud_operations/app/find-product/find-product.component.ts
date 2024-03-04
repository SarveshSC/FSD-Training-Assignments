import { Component } from '@angular/core';
import { Product } from '../product/product';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-find-product',
  templateUrl: './find-product.component.html',
  styleUrls: ['./find-product.component.css']
})
export class FindProductComponent {

  productList : Product[] = [];

  constructor(private productService : ProductService){}

  findProduct(name : string){
    this.productService.findByName(name).subscribe(
      (products) => {
        this.productList = products
        console.log(products);
      }
    );
  }

}
