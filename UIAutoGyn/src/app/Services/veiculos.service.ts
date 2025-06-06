import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MarcaComModelos, Marcas, Modelos } from '../Models/models';

@Injectable({
  providedIn: 'root'
})
export class VeiculosService {
  public static API_url: string = "http://localhost:8080/";
  
  constructor(private httpClient : HttpClient) {}

  getMarcas(){
    return this.httpClient.get<Marcas[]>(VeiculosService.API_url + 'marcas')
  }

  postMarca(marca : Marcas){
    return this.httpClient.post<Marcas>(VeiculosService.API_url + 'marcas', marca)
  }

  getMarcasEModelos() {
    return this.httpClient.get<MarcaComModelos[]>(VeiculosService.API_url + 'marcas/modelos');
  }

  postModelo(modelo : Object){
    return this.httpClient.post<Modelos>(VeiculosService.API_url + 'modelos', modelo)
  }

}
