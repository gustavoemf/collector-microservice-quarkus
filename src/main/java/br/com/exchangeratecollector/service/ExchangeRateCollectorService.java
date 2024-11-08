package br.com.exchangeratecollector.service;

import br.com.exchangeratecollector.api.ExchangeRateCollectorClient;
import br.com.exchangeratecollector.api.ExchangeRatePersistanceClient;
import br.com.exchangeratecollector.service.dto.MoedasRecord;
import io.quarkus.scheduler.Scheduled;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class ExchangeRateCollectorService {

    @Inject
    @RestClient
    ExchangeRateCollectorClient exchangeRateCollectorClient;

    @Inject
    @RestClient
    ExchangeRatePersistanceClient exchangeRatePersistanceClient;


    public void collectRates() {
        MoedasRecord response = exchangeRateCollectorClient.getRates("USD-BRL,BTC-BRL");
        exchangeRatePersistanceClient.sendExchangeRate(response.USDBRL());
        exchangeRatePersistanceClient.sendExchangeRate(response.BTCBRL());

        System.out.println(response);
        System.out.println(response.USDBRL());
        System.out.println(response.BTCBRL());
    }

}
