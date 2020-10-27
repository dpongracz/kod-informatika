package hu.dpongracz.kodinformatika.service;

import java.util.List;

public interface CurrencyChangeService {

	List<String> findSymbols();

	Integer convertCurrency(String fromCurrency, String toCurrency, int amount);

}
