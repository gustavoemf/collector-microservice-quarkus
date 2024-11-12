package br.com.exchangeratecollector.scheduler;

import br.com.exchangeratecollector.service.ExchangeRateCollectorService;
import io.quarkus.scheduler.Scheduled;

/**
 * Essa classe é responsável por temporizar a busca e envio de dados realizada pela {@link ExchangeRateCollectorService}
 */
public class ExchangeRateScheduler {

    private final ExchangeRateCollectorService collectorService;

    public ExchangeRateScheduler(ExchangeRateCollectorService collectorService) { this.collectorService = collectorService; }

    // O tempo entre cada busca é determinado pela variável every
    @Scheduled(every = "1m")
    public void retryGetMoedas(){
        collectorService.collectRates();
    }

}
