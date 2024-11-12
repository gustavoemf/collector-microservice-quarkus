package br.com.exchangeratecollector.config;

import br.com.exchangeratecollector.service.dto.ExchangeRateRecord;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serializer;

/**
 * Serializa objetos {@link ExchangeRateRecord} para um formato de byte[],
 * permitindo que eles sejam enviados para o Apache Kafka.
 *
 * Esta classe implementa a interface {@link Serializer} do Kafka, que define como
 * os objetos {@link ExchangeRateRecord} são convertidos em uma representação de
 * byte[] para serem transmitidos em mensagens Kafka.
 *
 * A serialização é realizada utilizando a biblioteca Jackson, que converte o
 * {@link ExchangeRateRecord} para o formato JSON em bytes.
 */
public class ExchangeRateRecordSerializer implements Serializer<ExchangeRateRecord> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public byte[] serialize(String topic, ExchangeRateRecord record) {
        try {
            return objectMapper.writeValueAsBytes(record);
        } catch (Exception e) {
            throw new RuntimeException("Error serializing ExchangeRateRecord", e);
        }
    }
}