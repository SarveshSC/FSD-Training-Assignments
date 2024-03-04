import { createReducer, on } from "@ngrx/store";
import { Airport } from "../../model/airport.model";
import {  addAirportAction, removeAirportAction, updateAirportAction } from "../actions/airport.action";

export interface AirportState{
    airports : Airport[]; 
}

export const initialState : AirportState = {
    airports: [
        {
            iataCode : 'DEL',
            name : 'Indira Gandhi International Airport',
            location : 'New Delhi'
        }
    ]
}

export const AirportReducer = createReducer(

    initialState,
    on(addAirportAction,(state,{airport})=>({

      ...state,
        airports:[...state.airports,airport]
    })),
    on(removeAirportAction,(state,{iataCode})=>({

        ...state,
        airports:state.airports.filter( (airport) => { return airport.iataCode !== iataCode})        
    })),
    on(updateAirportAction,(state,{iatacode, airport})=>({
        ...state,
        airports: state.airports.map( (airport) => (airport.iataCode === iatacode ? {...airport,airport}: airport )),
      }))

);

