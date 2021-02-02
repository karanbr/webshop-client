package de.leuphana.webshop.webshopclient.client;

import de.leuphana.webshop.webshopclient.model.CustomerDto;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Deprecated
@Component
@ConfigurationProperties(value = "de.leuphana.shop", ignoreUnknownFields = false)
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class CustomerClient {

    private final String CUSTOMER_PATH_V1 = "/api/v1/customer/";
    private final String apihost = "http://localhost:8080";
    private final RestTemplate restTemplate;

    public CustomerClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public CustomerDto getCustomerById(UUID customerId) {
        return restTemplate.getForObject(apihost + CUSTOMER_PATH_V1 + customerId.toString(), CustomerDto.class);
    }

    public URI saveNewCustomer(CustomerDto customerDto) {
        return restTemplate.postForLocation(apihost + CUSTOMER_PATH_V1, customerDto);
    }

    public void updateCustomer(UUID customerId, CustomerDto customerDto) {
        restTemplate.put(apihost + CUSTOMER_PATH_V1 + "/" + customerId.toString(), customerDto);
    }

    public void deleteCustomer(UUID customerId){
        restTemplate.delete(apihost + CUSTOMER_PATH_V1 + "/" + customerId.toString());
    }
}
