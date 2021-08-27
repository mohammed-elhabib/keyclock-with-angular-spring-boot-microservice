import { AccessDeniedComponent } from './access-denied/access-denied.component';
import { ManagerComponent } from './manager/manager.component';
import { AdminComponent } from './admin/admin.component';
import { APP_INITIALIZER, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { KeycloakAngularModule, KeycloakService } from 'keycloak-angular';
import { initializer } from './app-inits';
@NgModule({
  declarations: [
    AppComponent,
    AdminComponent,
    ManagerComponent,
    AccessDeniedComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    KeycloakAngularModule,
  ],
  providers: [ {
    provide: APP_INITIALIZER,
    useFactory: initializer,
    deps: [KeycloakService],
    multi: true,
  },],
  bootstrap: [AppComponent]
})
export class AppModule { }
