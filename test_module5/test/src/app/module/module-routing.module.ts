import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {MedicalComponent} from './medical/medical.component';
import {EditComponent} from './edit/edit.component';


const routes: Routes = [
  {
    path: '',
    component: MedicalComponent
  },
  {
    path: 'edit/:id',
    component: EditComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ModuleRoutingModule {
}
