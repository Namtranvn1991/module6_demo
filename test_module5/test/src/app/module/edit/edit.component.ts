import { Component, OnInit } from '@angular/core';
import {Medical} from '../../model/medical';
import {Subscription} from 'rxjs';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ServiceService} from '../../service/service.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {
  medical: Medical;
  private subscription: Subscription | undefined;
  id: string;
  form: FormGroup = this.formBuilder.group(
    {
      id: [],
      // patient: ['', [Validators.required]],
      patient: this.formBuilder.group(
        {
         id: [],
         name: ['', [Validators.required, Validators.pattern('[A-Z][a-z]*([ ][A-Z][a-z]*)*')]]
        }
      ),
      dayIn: ['', [Validators.required]],
      dayOut: ['', [Validators.required]],
      reason: ['', [Validators.required]],
      plan: ['', [Validators.required]],
      doctor: ['', [Validators.required]]
    }, {validators: this.checkDate.bind(this)}
  );

  constructor(private service: ServiceService, private activatedRoute: ActivatedRoute,
              private formBuilder: FormBuilder, private router: Router) { }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = paramMap.get('id');
    });
    this.subscription = this.service.getById(this.id).subscribe(
      data => {
        this.medical = data;
        console.log(this.medical);
        this.form.setValue(this.medical);
      }, error => {
        console.log(error);
      }
    );
  }

  checkDate(formGroup: FormGroup) {
    const {value: dayIn} = formGroup.get('dayIn');
    const {value: dayOut} = formGroup.get('dayOut');
    const dateIn = new Date(dayIn);
    const dateOut = new Date(dayOut);
    // @ts-ignore
    const timeDiff = dateOut - dateIn;
    const diff = Math.floor((timeDiff / (1000 * 3600 * 24)));
    return diff >= 0 ? null : {mustBeFutureDate: true};
  }

  onSubmit() {
    this.service.edit(this.form.value).subscribe(data => {
      console.log(data);
      this.router.navigateByUrl('/medical');
    }, error => {
      console.log(error);
    });
  }
}
