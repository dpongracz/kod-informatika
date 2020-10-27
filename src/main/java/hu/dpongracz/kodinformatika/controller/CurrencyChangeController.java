package hu.dpongracz.kodinformatika.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hu.dpongracz.kodinformatika.service.CurrencyChangeService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CurrencyChangeController {

	@Autowired
	private CurrencyChangeService currencyChangeService;

	@GetMapping(path = "/symbols")
	ResponseEntity<List<String>> findSymbols() {

		List<String> symbols = currencyChangeService.findSymbols();
		return ResponseEntity.ok(symbols);
	}

	@GetMapping(path = "/convert")
	ResponseEntity<Integer> countChildren(@RequestParam(name = "from", required = false) String from,
			@RequestParam(name = "to", required = false) String to, @RequestParam(name = "amount", required = false) int amount) {

		Integer result = currencyChangeService.convertCurrency(from, to, amount);
		return ResponseEntity.ok(result);
	}

}
