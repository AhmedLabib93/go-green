import { Component } from '@angular/core';
import { Router} from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'go-green-angular';
  public term : string = "";
  public isTokenThere:boolean = false;

  constructor(private router: Router){
    this.router = router;
    this.isTokenThere = localStorage.getItem('token') != null;
  }

  search(){
    this.router.navigate(["/shop", this.term]).then(() =>window.location.reload())
  }
}

