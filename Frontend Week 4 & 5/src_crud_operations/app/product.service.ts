import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Product } from './product/product';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private _http:HttpClient) { }

  baseURL = 'http://localhost:3000/products/'

  getAll() : Observable<Product>{
    return this._http.get<Product>(this.baseURL);
  }

  addProduct(product : Product) {
    this._http.post<Product>(this.baseURL, product).subscribe(
      (response) => console.log('Product added ', response)
    )
  }

  delete(id : number){
    this._http.delete<Product>(this.baseURL+id).subscribe(
      (response) => console.log(response), (err) => console.log(err)
    )
  }

  update(product : Product, id : Number){
    console.log(product)
    this._http.put<Product>(this.baseURL+id, product).subscribe(
      (response) => console.log("Product updated ", response)
    )
  }

  findByName(name : string) : Observable<Product[]>{
    console.log(name);
    let queryParams = new HttpParams();
    queryParams.append('name', name);
    console.log(this._http.get<Product[]>(this.baseURL,{params:queryParams}));

    return this._http.get<Product[]>(this.baseURL,{params:queryParams});
  }
}
