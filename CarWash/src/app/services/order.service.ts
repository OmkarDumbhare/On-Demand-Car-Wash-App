import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  baseUrl = "http://localhost:9003/order";

  constructor(private _http:HttpClient) { }

  //For Placing Order Using Post Method
  placeOrder(data:any) : Observable<Object>{
    return this._http.post(`${this.baseUrl}/place-order`,data,{responseType: 'text'});
  }

  //For Getting All the orders from Database
  public getAllOrders(){
    return this._http.get(`${this.baseUrl}/get-all`);
  }

  //For Getting Orders only for a specific Customer
  public getAllOrdersByCustomerName() {
    return this._http.get(`http://localhost:9000/customer/my-orders/`);
  } 

}
