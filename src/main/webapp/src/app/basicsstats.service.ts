import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {environment} from "../environments/environment";


@Injectable()
export class BasicStatsService {

  constructor(private http: HttpClient) {

  }

  getBasicStatsRaw(){
    return this.http.get(environment.basicStats,{responseType: 'text'});
  }
}
