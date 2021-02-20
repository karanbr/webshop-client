package de.leuphana.webshop.webshopclient.client;

import de.leuphana.webshop.webshopclient.model.ArticleDto;
import de.leuphana.webshop.webshopclient.model.CustomerDto;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
// import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
// @ConfigurationProperties(value = "de.leuphana.shop", ignoreUnknownFields = false)
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class ShopClient {

    public final String ARTICLE_PATH_V1 = "/api/v1/article/"; // Path will stay the same
    private final String CUSTOMER_PATH_V1 = "/api/v1/customer/";
    private final String apihost = "http://localhost:8080"; // host is going to vary from system to system
    private final RestTemplate restTemplate;

    public ShopClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build(); // Using Builder to build the Rest template
    }

    // Article Client

    public ArticleDto getArticleById(UUID articleId) {
        return restTemplate.getForObject(apihost + ARTICLE_PATH_V1 + articleId.toString(), ArticleDto.class);
    }

    public URI saveNewArticle(ArticleDto articleDto) {
        return restTemplate.postForLocation(apihost + ARTICLE_PATH_V1, articleDto);
    }

    public void updateArticle(UUID articleId, ArticleDto articleDto) {
        restTemplate.put(apihost + ARTICLE_PATH_V1 + "/" + articleId.toString(), articleDto);
    }

    public void deleteArticle(UUID articleid){
        restTemplate.delete(apihost + ARTICLE_PATH_V1 + "/" + articleid.toString());
    }

    // Customer Client

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

/*    public void setApihost(String apihost) {
        this.apihost = apihost;
    }*/
}
