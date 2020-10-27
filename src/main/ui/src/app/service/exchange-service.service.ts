import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Currency } from '../domain/currency';

@Injectable({
    providedIn: 'root'
})
export class ExchangeServiceService {

    private currencyUrl: string;

    constructor(private http: HttpClient) {

        this.currencyUrl = 'http://localhost:8080/';
    }

    public findSymbols(): Observable<Currency[]> {
        return this.http.get<Currency[]>(this.currencyUrl);
    }

    public calculateRate(from: string, to: string, amount: number): Observable<Currency[]> {
        return this.http.get<Currency[]>(`${this.currencyUrl}/?convert&from=${from}&to=${to}&amount=${amount}`);
    }
}
