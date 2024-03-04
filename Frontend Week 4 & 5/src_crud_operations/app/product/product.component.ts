import { Component } from '@angular/core';
import { ProductService } from '../product.service';
import { Product } from './product';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent {

  productList : any;

  constructor(private productService:ProductService){

  }

  getAllProducts(){
    this.productService.getAll().subscribe( (products) => {
      this.productList = products;
      console.log(products);
    });
  }

  deleteById(data : number){
    this.productService.delete(data);
  }

}
