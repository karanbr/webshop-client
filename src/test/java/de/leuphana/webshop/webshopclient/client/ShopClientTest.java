package de.leuphana.webshop.webshopclient.client;

import de.leuphana.webshop.webshopclient.model.ArticleDto;
import de.leuphana.webshop.webshopclient.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.net.URL;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;


@Slf4j
@SpringBootTest
class ShopClientTest {

    @Autowired // Allow Spring boot to create instance of this
    ShopClient shopClient;

    // Article Client tests
    @Test
    void getArticleById() {
        ArticleDto article = shopClient.getArticleById(UUID.randomUUID());
        assertNotNull(article);
    }

    @Test
    void testSaveNewArticle() {
        ArticleDto articleDto = ArticleDto.builder().name("New Article").build();
        URI uri = shopClient.saveNewArticle(articleDto);
        assertNotNull(uri);
        log.info(uri.toString());
        System.out.println(uri.toString());
    }

    @Test
    void testUpdateArticle() {
        ArticleDto articleDto = ArticleDto.builder().name("New Article").build();
        shopClient.updateArticle(UUID.randomUUID(), articleDto);
    }

    @Test
    void testDeleteArticle() {
        shopClient.deleteArticle(UUID.randomUUID());
    }

    // Customer Client tests

    @Test
    void testGetCustomerById() {
        CustomerDto customerDto = shopClient.getCustomerById(UUID.randomUUID());
        assertNotNull(customerDto);
    }

    @Test
    void testSaveNewCustomer() {
        CustomerDto customerDto = CustomerDto.builder().name("Henry").build();
        URI uri = shopClient.saveNewCustomer(customerDto);
        assertNotNull(uri);
    }

    @Test
    void testUpdateCustomer() {
        CustomerDto customerDto = CustomerDto.builder().name("Henry").build();
        shopClient.updateCustomer(UUID.randomUUID(), customerDto);
    }

    @Test
    void testDeleteCustomer() {
        shopClient.deleteCustomer(UUID.randomUUID());
    }
}