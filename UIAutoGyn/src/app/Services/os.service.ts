import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { OrdensServico } from '../Models/models';
import { Observable } from 'rxjs';

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

  aprovar(id : number){
    return this.httpClient.post<OrdensServico>(OsService.API_url+`/${id}/aprovar`, null)
  }

  pagar(id : number, valorPago : number){
    return this.httpClient.post<OrdensServico>(OsService.API_url+`/${id}/pagar?valorPago=${valorPago}`, null)
  }

  cancelar(id : number){
    return this.httpClient.post<OrdensServico>(OsService.API_url+`/${id}/cancelar`, null)
  }

  getRelatorios(): Observable<Blob> {
    return this.httpClient.get(OsService.API_url + `/relatorios`, {
      responseType: 'blob' 
    });
  }
}
