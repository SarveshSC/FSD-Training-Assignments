import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UpdateFormComponent } from './components/update-form/update-form.component';
import { PlayerListComponent } from './components/player-list/player-list.component';

const routes: Routes = [
  {path:'update-form', component:UpdateFormComponent},
  {path:'home', component:PlayerListComponent},
  {path:'**', redirectTo:'home'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
