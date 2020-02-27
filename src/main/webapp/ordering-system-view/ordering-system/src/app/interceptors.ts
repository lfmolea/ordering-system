import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from "@angular/common/http";
import {Observable} from "rxjs/internal/Observable";
import {Injectable} from "@angular/core";

@Injectable()
export class Interceptors implements HttpInterceptor {

intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
      console.log('INTERCEPTOR');
      // We retrieve the token, if any

      const token = window.localStorage.getItem('token')
      let newHeaders = request.headers;
      if (token) {
         // If we have a token, we append it to our new headers
         newHeaders = newHeaders.append('authtoken', token);
      }
      // Finally we have to clone our request with our new headers
      // This is required because HttpRequests are immutable
      const authReq = request.clone({headers: newHeaders});
      // Then we return an Observable that will run the request
      // or pass it to the next interceptor if any
      return next.handle(authReq);
   }
}
