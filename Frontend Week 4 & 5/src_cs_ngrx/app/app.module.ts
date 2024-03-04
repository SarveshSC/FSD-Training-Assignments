import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AirportsComponent } from './components/airports/airports.component';
import { FormsModule } from '@angular/forms';
import { StoreModule } from '@ngrx/store';
import { AirportReducer } from './store/reducers/airport.reducer';

@NgModule({
  declarations: [
    AppComponent,
    AirportsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    StoreModule.forRoot({airports: AirportReducer})
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
