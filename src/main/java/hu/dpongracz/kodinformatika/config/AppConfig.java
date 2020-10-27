package hu.dpongracz.kodinformatika.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import hu.dpongracz.kodinformatika.service.CurrencyChangeService;
import hu.dpongracz.kodinformatika.service.impl.CurrencyChangeServiceImpl;

@Configuration
@EnableAutoConfiguration()
@EnableJpaRepositories(basePackages = "hu.dpongracz.kodinformatika.repository")
public class AppConfig {

	@Bean
	CurrencyChangeService currencyChangeService() {
		return new CurrencyChangeServiceImpl();
	}

}
