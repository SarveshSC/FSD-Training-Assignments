import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { player } from 'src/app/model/player.model';
import { PlayerService } from 'src/app/service/player.service';

@Component({
  selector: 'app-update-form',
  templateUrl: './update-form.component.html',
  styleUrls: ['./update-form.component.css']
})
export class UpdateFormComponent {

  constructor(private service : PlayerService, private route : Router) {}

  updatePlayer(input : player){
    this.service.updatePlayer(input);
  }

  getSelected(){
    return this.service.getSelected();
  }
}
