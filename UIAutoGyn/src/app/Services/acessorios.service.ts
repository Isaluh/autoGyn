import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Acessorios } from '../Models/models';

@Injectable({
  providedIn: 'root'
})
export class AcessoriosService {
  public static API_url: string = "http://localhost:8080/acessorios";
  
  constructor(private httpClient : HttpClient) {}

  getAcessorios(){
    return this.httpClient.get<Acessorios[]>(AcessoriosService.API_url)
  }

  postAcessorio(acessorio : Acessorios){
    return this.httpClient.post<Acessorios>(AcessoriosService.API_url, acessorio)
  }
}
