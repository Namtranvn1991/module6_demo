export interface CustomerType {
  id: number;
  name: string;
  dateOfBirth: Date;
  gender: number;
  idCard: string;
  phone: string;
  email: string;
  address: string;
  cusType: CustomerType;
}
