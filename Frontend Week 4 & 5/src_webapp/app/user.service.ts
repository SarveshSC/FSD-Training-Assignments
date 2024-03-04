import { Injectable } from '@angular/core';
import { User } from './User';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor() { 
    console.log('user service generated')
  }

users : User[] = [
  {"uid":101, "username":"King","email":"king@gmail.com", "city" : "Mumbai" },
  {"uid":102, "username":"Ron","email":"ron@gmail.com", "city" : "Delhi" },
  {"uid":103, "username":"Rick","email":"rick@gmail.com", "city" : "Mumbai" }
];

getAllUsers(){
  console.log('getAllUsers() called');
  return this.users;
}
}