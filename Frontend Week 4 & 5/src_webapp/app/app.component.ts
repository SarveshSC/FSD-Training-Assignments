import { Component } from '@angular/core';
import { UserService } from './user.service';
import { User } from './User';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'webapp';

  userList : User[] = [];

  constructor(private UserService : UserService){

  }

  getAll(){
    this.userList = this.UserService.getAllUsers();
  }
}
