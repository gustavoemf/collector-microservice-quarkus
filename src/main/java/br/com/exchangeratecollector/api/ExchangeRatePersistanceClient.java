package br.com.exchangeratecollector.api;

import br.com.exchangeratecollector.service.dto.ExchangeRateRecord;
import br.com.exchangeratecollector.service.dto.MoedasRecord;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/exchange-rate")
@RegisterRestClient(configKey = "http://localhost:8080")
public interface ExchangeRatePersistanceClient {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    void sendExchangeRate(ExchangeRateRecord response);
}
