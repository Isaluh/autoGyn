import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { OrdensServico } from '../Models/models';

@Injectable({
  providedIn: 'root'
})
export class OsService {
  public static API_url: string = "http://localhost:8080/OS";
  
  constructor(private httpClient : HttpClient) {}

  getOS(){
    return this.httpClient.get<any>(OsService.API_url)
  }

  postOS(os : any){
    return this.httpClient.post<OrdensServico>(OsService.API_url, os)
  }
}
