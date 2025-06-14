import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Servicos } from '../Models/models';

@Injectable({
  providedIn: 'root'
})
export class ServicosService {
  public static API_url: string = "http://localhost:8080/servicos";
  
  constructor(private httpClient : HttpClient) {}

  getServicos(){
    return this.httpClient.get<Servicos[]>(ServicosService.API_url)
  }

  postServico(servico : Servicos){
    return this.httpClient.post<Servicos>(ServicosService.API_url, servico)
  }
}
