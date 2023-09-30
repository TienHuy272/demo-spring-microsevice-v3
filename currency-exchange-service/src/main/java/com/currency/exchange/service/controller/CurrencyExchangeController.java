package com.currency.exchange.service.controller;

import com.currency.exchange.service.bean.CurrencyExchange;
import com.currency.exchange.service.repository.CurrencyExchangeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CurrencyExchangeController {

    @Autowired
    private Environment environment;
    @Autowired
    private CurrencyExchangeRepository currencyExchangeRepository;
    private Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {

        logger.info("Logging Infor : {} - {}", from , to);
        String port = environment.getProperty("local.server.port");
        CurrencyExchange currencyExchange = currencyExchangeRepository.findFirstByFromAndTo(from, to);
        if (currencyExchange == null) {
            throw new RuntimeException("Unable to find data " + from + to);
        }
        currencyExchange.setEnvironment(port);
        return currencyExchange;
    }
}
