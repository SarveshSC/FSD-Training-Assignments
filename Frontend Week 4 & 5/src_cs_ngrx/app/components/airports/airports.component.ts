import { Component } from '@angular/core';
import { Airport } from '../../model/airport.model';
import { Store } from '@ngrx/store';
import { addAirportAction, removeAirportAction } from '../../store/actions/airport.action';

@Component({
  selector: 'app-airports',
  templateUrl: './airports.component.html',
  styleUrls: ['./airports.component.css']
})
export class AirportsComponent {

  airportList !: Airport[];

  constructor(private store : Store<{airports : {airports:Airport[]}}>){
    store.select('airports').subscribe((AirportState:{airports : Airport[]}) => {
      this.airportList = AirportState.airports;
      console.log(this.airportList);
    }
    
    )
  }

  getAirport(airport : Airport){
    console.log(airport);
  }

  addAirport(airport : Airport){
    if(airport.iataCode.trim() === '' || airport.name.trim() === '' || airport.name.trim() === ''){
      return;
    }

    this.store.dispatch(addAirportAction({airport}));
  }

  removeAirport(iataCode : string){
    this.store.dispatch(removeAirportAction({iataCode}));
  }

  updateAirport(airport : Airport){
    
  }
}
