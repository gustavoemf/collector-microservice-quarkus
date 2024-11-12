package br.com.exchangeratecollector.service;

import br.com.exchangeratecollector.api.ExchangeRateCollectorClient;
import br.com.exchangeratecollector.service.dto.ExchangeRateRecord;
import br.com.exchangeratecollector.service.dto.MoedasRecord;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class ExchangeRateCollectorService {

    @Inject
    @RestClient
    ExchangeRateCollectorClient exchangeRateCollectorClient;

    @Inject
    @Channel("exchange-rates")
    Emitter<ExchangeRateRecord> emitter;  // Modificado para ExchangeRateRecord

    public void collectRates() {
        MoedasRecord response = exchangeRateCollectorClient.getRates("USD-BRL,BTC-BRL");

        emitter.send(response.USDBRL());
        emitter.send(response.BTCBRL());

        System.out.println(response);
        System.out.println(response.USDBRL());
        System.out.println(response.BTCBRL());
    }

}
