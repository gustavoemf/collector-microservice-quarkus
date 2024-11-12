package br.com.exchangeratecollector.service.dto;

public record ExchangeRateRecord(String name, double bid, double ask, String timestamp) {
}
