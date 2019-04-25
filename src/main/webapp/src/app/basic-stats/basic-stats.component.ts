import {Component, OnInit} from '@angular/core';
import {BasicStatsService} from "../basicsstats.service";
import {log} from "util";

@Component({
  selector: 'app-basic-stats',
  templateUrl: './basic-stats.component.html',
  styleUrls: ['./basic-stats.component.css'],
  providers: [BasicStatsService]
})
export class BasicStatsComponent implements OnInit {

  rawText: string;
  statsService: BasicStatsService;

  devices: string[];

  constructor(basicStatsService: BasicStatsService) {
    this.statsService = basicStatsService;
  }

  ngOnInit() {
    this.statsService.getBasicStatsRaw().subscribe((data: string) => {
      this.rawText = data;
      this.getDevicesFromRawText(data);
    });

  }

  getDevicesFromRawText(rawText:String) {
    this.devices = this.rawText.split('\n\n');
    this.devices.forEach(element => log(element));
    log(this.rawText);
  }

}
