import { Component } from '@angular/core';

@Component({
  selector: 'app-parent',
  templateUrl: './parent.component.html',
  styleUrls: ['./parent.component.css']
})
export class ParentComponent {
  parentData : String = "Surname is Smith";
  childData : String = "";

  getChildData(data : any){
    console.log(data);
    this.childData = data;
  }
}
