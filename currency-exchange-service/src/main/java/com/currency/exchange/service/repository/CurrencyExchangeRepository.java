package com.currency.exchange.service.repository;

import com.currency.exchange.service.bean.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {
    CurrencyExchange findFirstByFromAndTo(String from, String to);
}
