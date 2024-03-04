import { createAction, props } from "@ngrx/store";
import { Airport } from "../../model/airport.model";

export const addAirportAction = createAction(
    '[Airport] add Airport',
    props<{airport : Airport}>()
)

export const updateAirportAction = createAction(
    '[Airport] update Airport',
    props<{iatacode : string, airports : Airport}>()
)

export const removeAirportAction = createAction(
    '[Airport] remove Airport',
    props<{iataCode : string}>()
)