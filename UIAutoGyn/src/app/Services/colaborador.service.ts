import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Colaboradores } from '../Models/models';

@Injectable({
  providedIn: 'root'
})
export class ColaboradorService {
  public static API_url: string = "http://localhost:8080/colaboradores";
  
  constructor(private httpClient : HttpClient) {}

  getColaboradores(){
    return this.httpClient.get<Colaboradores[]>(ColaboradorService.API_url)
  }

  postColaborador(colaborador : Colaboradores){
    return this.httpClient.post<Colaboradores>(ColaboradorService.API_url, colaborador)
  }
}
