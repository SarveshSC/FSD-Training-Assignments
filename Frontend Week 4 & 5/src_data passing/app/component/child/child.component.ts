import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-child',
  templateUrl: './child.component.html',
  styleUrls: ['./child.component.css']
})
export class ChildComponent {

  @Input()
  myInput : String = "";

  @Output()
  myEventEmitter:EventEmitter<String> = new EventEmitter();

  myOutput : String = "My name is Steve";

  sendChildData(){
    console.log("send child data called");
    this.myEventEmitter.emit(this.myOutput);
  }

}
