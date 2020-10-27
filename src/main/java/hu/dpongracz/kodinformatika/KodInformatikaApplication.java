package hu.dpongracz.kodinformatika;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.util.CollectionUtils;

import hu.dpongracz.kodinformatika.domain.Currency;
import hu.dpongracz.kodinformatika.domain.CurrencyExchangeRate;
import hu.dpongracz.kodinformatika.repository.CurrencyExchangeRateRepository;
import hu.dpongracz.kodinformatika.repository.CurrencyRepository;

@SpringBootApplication
public class KodInformatikaApplication {

	public static void main(String[] args) {
		SpringApplication.run(KodInformatikaApplication.class, args);
	}

	@Bean
	CommandLineRunner init(CurrencyRepository currencyRepository, CurrencyExchangeRateRepository currencyExchangeRateRepository) {
		return args -> {

			List<Currency> symbols = currencyRepository.findAll();

			if (CollectionUtils.isEmpty(symbols)) {
				Stream.of("EUR", "HUF").forEach(symbol -> {

					Currency curr = new Currency();
					curr.setSymbol(symbol);

					currencyRepository.save(curr);
					symbols.add(curr);
				});

			}

			List<CurrencyExchangeRate> rates = currencyExchangeRateRepository.findAll();

			if (CollectionUtils.isEmpty(rates)) {

				Currency eur = symbols.stream().filter(s -> s.getSymbol().equals("EUR")).findFirst().get();
				Currency huf = symbols.stream().filter(s -> s.getSymbol().equals("HUF")).findFirst().get();

				CurrencyExchangeRate eurHuf = new CurrencyExchangeRate();
				eurHuf.setFromCurrency(eur.getSymbol());
				eurHuf.setToCurrency(huf.getSymbol());
				eurHuf.setRate(330);

				rates.add(eurHuf);

				CurrencyExchangeRate hufEur = new CurrencyExchangeRate();

				hufEur.setFromCurrency(huf.getSymbol());
				hufEur.setToCurrency(eur.getSymbol());
				hufEur.setRate(1 / 330);

				rates.add(hufEur);

				currencyExchangeRateRepository.saveAll(rates);
			}
		};
	}

}
