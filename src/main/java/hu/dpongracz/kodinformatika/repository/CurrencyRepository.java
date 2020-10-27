package hu.dpongracz.kodinformatika.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hu.dpongracz.kodinformatika.domain.Currency;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {

}
