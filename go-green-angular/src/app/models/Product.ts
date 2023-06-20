import {Byte} from '@angular/compiler/src/util'

export class Product {
    id : Number;
    name : String;
    description : string;
    price : Number;
    addedOn : Date;
    image : [Byte];
    imageUrl : string;
}