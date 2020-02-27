import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {User} from "../model/user";
import {Observable} from "rxjs/index";
import {ApiResponse} from "./api-response";

@Injectable()
export class ApiService {
private baseUrl: string;
constructor(private http: HttpClient) {
  this.baseUrl = 'http://localhost:8080/users';
}
  login(loginPayload) : Observable<ApiResponse> {
    return this.http.post<ApiResponse>('http://localhost:8080/' + 'token/generate-token', loginPayload);
  }

  getUsers() : Observable<ApiResponse> {
    return this.http.get<ApiResponse>(this.baseUrl);
  }

  getUserById(id: number): Observable<ApiResponse> {
    return this.http.get<ApiResponse>(this.baseUrl + id);
  }

  createUser(user: User): Observable<ApiResponse> {
    return this.http.post<ApiResponse>(this.baseUrl, user);
  }

  updateUser(user: User): Observable<ApiResponse> {
    return this.http.put<ApiResponse>(this.baseUrl + user.id, user);
  }

  deleteUser(id: number): Observable<ApiResponse> {
    return this.http.delete<ApiResponse>(this.baseUrl + id);
  }
 public findAll(): Observable<User[]> {
    return this.http.get<User[]>(this.baseUrl);
  }

  public save(user: User) {
    return this.http.post<User>(this.baseUrl, user);
  }
}
