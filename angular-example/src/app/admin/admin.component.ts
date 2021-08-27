import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { environment } from 'src/environments/environment';
import { TestService } from '../test.service';

@Component({
  selector: 'app-admin',
   templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.scss'],
})
export class AdminComponent implements OnInit {
  message1 = 'message';
  message2 = 'message';

  constructor(private testService: TestService) {}

  ngOnInit(): void {
    this.testService.getTestAdminMessage().subscribe(x=>{
      this.message1=x.message.message;
      this.message2=x.message.message2;
      console.log(x.message)

    })
  }
}
