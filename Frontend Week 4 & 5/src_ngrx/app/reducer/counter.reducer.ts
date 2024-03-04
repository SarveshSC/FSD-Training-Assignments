import { createReducer, on } from "@ngrx/store";
import { decrement, increment, reset } from "../actions/counter.actions";

export const initialState = 0;

export const counterReducer = createReducer(
    initialState,
    on(increment, (state : number) => {return state + 1;}),
    on(decrement, (state : number) => {return state - 1;}),
    on(reset, (state : number) => {return 0}),

    
)