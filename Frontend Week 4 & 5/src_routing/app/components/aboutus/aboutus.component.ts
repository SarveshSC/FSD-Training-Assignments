import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-aboutus',
  templateUrl: './aboutus.component.html',
  styleUrls: ['./aboutus.component.css']
})
export class AboutusComponent {
  paramList:any = [];


    constructor(private route:ActivatedRoute){

        route.queryParams.subscribe(
                       (input) => { 
                            this.paramList = input  
                            console.log(this.paramList);
                          
                          }
                       
                       );


    }
}
