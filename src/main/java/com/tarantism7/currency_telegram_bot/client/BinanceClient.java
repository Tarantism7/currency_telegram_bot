package com.tarantism7.currency_telegram_bot.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Slf4j
public class BinanceClient {
    private final HttpGet httpGet;
    private final ObjectMapper objectMapper;
    private final HttpClient httpClient;

    public BinanceClient(@Value("${binance.api.getPrice}") String uri) {
        httpGet = new HttpGet(uri);
        objectMapper = new ObjectMapper();
        httpClient = HttpClientBuilder.create()
                .setSSLHostnameVerifier(new NoopHostnameVerifier())
                .build();
    }

    public double getBitcoinPrice() throws IOException {
        log.info("Performing call to get bitcoin price");
        try {
            return objectMapper.readTree(EntityUtils.toString(httpClient.execute(httpGet).getEntity()))
                    .path("price").asDouble();
        } catch (IOException e) {
            log.error("Failed to parse bitcoin price", e);
            throw e;
        }
    }
}
