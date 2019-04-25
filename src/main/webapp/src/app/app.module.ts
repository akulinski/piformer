import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { BasicStatsComponent } from './basic-stats/basic-stats.component';
import {BasicStatsService} from "./basicsstats.service";
import { HttpClientModule } from '@angular/common/http';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';


@NgModule({
  declarations: [
    AppComponent,
    BasicStatsComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    NgbModule
  ],
  providers: [BasicStatsService],
  bootstrap: [AppComponent,BasicStatsComponent]
})
export class AppModule { }
