import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccessDeniedComponent } from './access-denied/access-denied.component';
import { AdminComponent } from './admin/admin.component';
import { AuthGuard } from './auth.guard';
import { ManagerComponent } from './manager/manager.component';

const routes: Routes = [
  {
    path: 'access-denied',
    component: AccessDeniedComponent,
    canActivate: [AuthGuard],
  },
  {
    path: 'admin',
    component: AdminComponent,
    canActivate: [AuthGuard],
    data: { roles: ['ROLE_ADMIN'] },
  },
  {
    path: 'manager',
    component: ManagerComponent,
    canActivate: [AuthGuard],
    data: { roles: ['ROLE_MANAGER'] },
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
