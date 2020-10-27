package hu.dpongracz.kodinformatika.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hu.dpongracz.kodinformatika.domain.CurrencyExchangeRate;

@Repository
public interface CurrencyExchangeRateRepository extends JpaRepository<CurrencyExchangeRate, Long> {

	double findByFromCurrencyAndToCurrency(String from, String to);

}