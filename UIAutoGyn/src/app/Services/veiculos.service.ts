import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class VeiculosService {
public static API_url: string = "http://localhost:8080/";
  
  constructor(private httpClient : HttpClient) {}

  // getLivros(){
  //   return this.httpClient.get<Livro[]>(LivroService.API_url)
  // }

  // postLivro(livro : Livro){
  //   return this.httpClient.post<Livro>(LivroService.API_url+'/add', livro)
  // }

  // putLivro(livro : Livro){
  //   return this.httpClient.put<Livro>(LivroService.API_url+'/update', livro)
  // }

  // delLivro(id : number){
  //   return this.httpClient.delete<Livro>(LivroService.API_url+`/${id}`)
  // }
}
