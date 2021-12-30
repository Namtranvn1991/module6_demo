import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ModuleRoutingModule } from './module-routing.module';
import { MedicalComponent } from './medical/medical.component';
import {NgxPaginationModule} from 'ngx-pagination';
import { EditComponent } from './edit/edit.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';


@NgModule({
  declarations: [MedicalComponent, EditComponent],
  imports: [
    CommonModule,
    ModuleRoutingModule,
    NgxPaginationModule,
    ReactiveFormsModule,
    FormsModule
  ]
})
export class ModuleModule { }
