package io.avinash.microservices.currencyexchangeservice.resources;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.avinash.microservices.currencyexchangeservice.entities.ExchangeValue;

@RestController
public class CurrencyExchangeController {

	@Autowired
	Environment environment;
	
	@GetMapping("/currency-exchange/{from}/to/{to}")
	public ExchangeValue retriveExchangeValue(@PathVariable String from, @PathVariable String to) {
		ExchangeValue value = new ExchangeValue(1L, from, to, BigDecimal.valueOf(750l));
		value.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		return value;
	}
}
