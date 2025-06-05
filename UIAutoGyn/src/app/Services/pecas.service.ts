import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Pecas } from '../Models/models';

@Injectable({
  providedIn: 'root'
})
export class PecasService {
  public static API_url: string = "http://localhost:8080/pecas";
  
  constructor(private httpClient : HttpClient) {}

  getPecas(){
    return this.httpClient.get<Pecas[]>(PecasService.API_url)
  }

  postPeca(peca : Pecas){
    return this.httpClient.post<Pecas>(PecasService.API_url, peca)
  }
}
