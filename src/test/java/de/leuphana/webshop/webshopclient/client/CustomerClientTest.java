package de.leuphana.webshop.webshopclient.client;

import de.leuphana.webshop.webshopclient.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@Deprecated
@SpringBootTest
class CustomerClientTest {

    @Autowired // Spring boot creates instance
    CustomerClient customerClient;

    @Test
    void testGetCustomerById() {
        CustomerDto customerDto = customerClient.getCustomerById(UUID.randomUUID());
        assertNotNull(customerDto);
    }

    @Test
    void testSaveNewCustomer() {
        CustomerDto customerDto = CustomerDto.builder().name("Henry").build();
        URI uri = customerClient.saveNewCustomer(customerDto);
        assertNotNull(uri);
    }

    @Test
    void testUpdateCustomer() {
        CustomerDto customerDto = CustomerDto.builder().name("Henry").build();
        customerClient.updateCustomer(UUID.randomUUID(), customerDto);
    }

    @Test
    void testDeleteCustomer() {
        customerClient.deleteCustomer(UUID.randomUUID());
    }
}