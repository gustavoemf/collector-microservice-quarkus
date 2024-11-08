package br.com.exchangeratecollector.scheduler;

import br.com.exchangeratecollector.service.ExchangeRateCollectorService;
import io.quarkus.scheduler.Scheduled;

public class ExchangeRateScheduler {

    private final ExchangeRateCollectorService collectorService;

    public ExchangeRateScheduler(ExchangeRateCollectorService collectorService) { this.collectorService = collectorService; }

    @Scheduled(every = "1m")
    public void retryGetMoedas(){
        collectorService.collectRates();
    }

}
