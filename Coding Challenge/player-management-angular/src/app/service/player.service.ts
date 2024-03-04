import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { player } from '../model/player.model';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class PlayerService {

  selected : number = 0;
  
  constructor(private http : HttpClient, private route : Router) { }
  
  baseURL : string = 'http://localhost:8080/api/players/';
  
  
  getPlayers() : Observable<player[]>{
    return this.http.get<player[]>(this.baseURL+'getall');
  }
  
  updatePlayer(input : any){
    console.log(input);
    // const options: { responseType: 'text' as 'text'} ;
    console.log(this.baseURL+'updateFields');
    this.http.put(this.baseURL+'updateFields',input).subscribe(
      (response) => {
        if(response) console.log('Player Updated'); this.route.navigate(['home']) ;
      },
        (error) => {
          console.error('PUT Request failed:', error.error);
          alert(error.error);
        }
    )
  }

  setSelected(id : number){
    this.selected = id;
  }

  getSelected(){
    return this.selected;
  }
}
