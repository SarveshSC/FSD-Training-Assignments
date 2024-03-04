import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { AboutusComponent } from './components/aboutus/aboutus.component';
import { ContactusComponent } from './components/contactus/contactus.component';
import { PaymentComponent } from './components/payment/payment.component';

const routes: Routes = [
  {path:'home', component:HomeComponent},
  {path:'contact/:username', component:ContactusComponent},
  {path:'about', component:AboutusComponent},
  {path:'payment/:billamount', component:PaymentComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
