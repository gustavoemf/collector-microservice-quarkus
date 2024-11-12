package br.com.exchangeratecollector.service.dto;

import java.time.LocalDateTime;

public record ExchangeRateRecord(String name, double bid, double ask, LocalDateTime timestamp) {
}
