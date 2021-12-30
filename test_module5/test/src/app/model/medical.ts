import {Patient} from './patient';

export interface Medical {
  id: string;
  patient: Patient;
  dayIn: Date;
  dayOut: Date;
  reason: string;
  plan: string;
  doctor: string;
}
