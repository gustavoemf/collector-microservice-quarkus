package br.com.exchangeratecollector.api;

import br.com.exchangeratecollector.service.ExchangeRateCollectorService;
import br.com.exchangeratecollector.service.dto.MoedasRecord;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

/**
 * Interface que define um cliente REST para consumir a API de cotações de moedas.
 *
 * Esta interface é responsável por fazer uma requisição GET para o endpoint que retorna
 * as cotações das moedas no formato JSON.
 *
 * A interface define um único método para consultar as taxas de câmbio, passando o nome
 * da moeda (determinado na {@link ExchangeRateCollectorService}) como parâmetro na URL.
 */
@Path("/last/{moedas}")
@RegisterRestClient(configKey  = "https://economia.awesomeapi.com.br/json")
public interface ExchangeRateCollectorClient {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public MoedasRecord getRates(@PathParam("moedas") String moedas);
}
