package br.com.exchangeratecollector.api;

import br.com.exchangeratecollector.service.dto.MoedasRecord;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/last/{moedas}")
@RegisterRestClient(configKey  = "https://economia.awesomeapi.com.br/json")
public interface ExchangeRateCollectorClient {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public MoedasRecord getRates(@PathParam("moedas") String moedas);
}
