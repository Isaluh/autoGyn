import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class OsService {
  public static API_url: string = "http://localhost:8080/";
  
  constructor(private httpClient : HttpClient) {}

  // getMarcas(){
  //   return this.httpClient.get<Marcas[]>(VeiculosService.API_url + 'marcas')
  // }

  // postMarca(marca : Marcas){
  //   return this.httpClient.post<Marcas>(VeiculosService.API_url + 'marcas', marca)
  // }
}
