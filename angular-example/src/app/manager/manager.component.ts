import { TestService } from './../test.service';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpHeaders} from '@angular/common/http';
@Component({
  selector: 'app-manager',
  templateUrl: './manager.component.html',
  styleUrls: ['./manager.component.scss'],
})
export class ManagerComponent implements OnInit {
  message1 = 'message';
  message2 = 'message';

  constructor(private testService: TestService) {}

  ngOnInit(): void {
    this.testService.getTestManagerMessage().subscribe(x=>
      {
        this.message1=x.message.message;
        this.message2=x.message.message2;
        console.log(x.message)
    }
      )
  }
}
