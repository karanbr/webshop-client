package de.leuphana.webshop.webshopclient.config;

import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

public class BlockingRestTemplateCustomizer implements RestTemplateCustomizer {


    @Override
    public void customize(RestTemplate restTemplate) {

    }
}
