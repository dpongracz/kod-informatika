package hu.dpongracz.kodinformatika.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hu.dpongracz.kodinformatika.domain.Currency;
import hu.dpongracz.kodinformatika.repository.CurrencyRepository;
import hu.dpongracz.kodinformatika.service.CurrencyChangeService;

@Service
public class CurrencyChangeServiceImpl implements CurrencyChangeService {

	@Autowired
	private CurrencyRepository currencyRepository;

	@Override
	@Transactional(readOnly = true)
	public List<String> findSymbols() {

		List<Currency> symbols = currencyRepository.findAll();

		return symbols.stream().map(x -> x.getSymbol()).collect(Collectors.toList());
	}

	@Override
	public Integer convertCurrency(String fromCurrency, String toCurrency, int amount) {
		// TODO Convert method
		return null;
	}

}
