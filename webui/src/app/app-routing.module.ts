import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {BlipKeycloakAuthGuard} from "./keycloak/blip-keycloak-auth-guard";
import {HomeComponent} from "./home/home.component";
import {OriginatedByMeComponent} from "./originated-by-me/originated-by-me.component";

const routes: Routes = [
  {path: '', component: HomeComponent, canActivate: [BlipKeycloakAuthGuard]},
  {path: 'originated-by-me', component: OriginatedByMeComponent},
  {path: '**', redirectTo: ''}
]

@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
