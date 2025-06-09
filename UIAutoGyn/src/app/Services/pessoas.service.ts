import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Clientes, Colaboradores } from '../Models/models';

@Injectable({
  providedIn: 'root'
})
export class PessoasService {
  public static API_url: string = "http://localhost:8080/";
  
  constructor(private httpClient : HttpClient) {}

  getColaboradores(){
    return this.httpClient.get<Colaboradores[]>(PessoasService.API_url+'colaboradores')
  }

  postColaborador(colaborador : Colaboradores){
    return this.httpClient.post<Colaboradores>(PessoasService.API_url+'colaboradores', colaborador)
  }

  postCliente(cliente : Clientes){
    return this.httpClient.post<Clientes>(PessoasService.API_url+'clientes', cliente)
  }

  getClientes(){
    return this.httpClient.get<Clientes[]>(PessoasService.API_url+'clientes')
  }
}
