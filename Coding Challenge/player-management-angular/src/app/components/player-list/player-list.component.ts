import {  Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { player } from 'src/app/model/player.model';
import { PlayerService } from 'src/app/service/player.service';

@Component({
  selector: 'app-player-list',
  templateUrl: './player-list.component.html',
  styleUrls: ['./player-list.component.css']
})
export class PlayerListComponent implements OnInit{
  playerList : player[] = [];

  constructor(private service : PlayerService, private route : Router) {} 

  ngOnInit(): void {
    this.getPlayers();
  }

  getPlayers(){
    this.service.getPlayers().subscribe( (list) => this.playerList = list);
  }

  getToForm(){
    this.route.navigate(['list']);
  }

  setSelected(id : number){
    this.service.setSelected(id);
  }
}

