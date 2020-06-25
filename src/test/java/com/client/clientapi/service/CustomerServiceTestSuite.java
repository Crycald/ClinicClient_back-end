package com.client.clientapi.service;

import com.client.clientapi.domain.CustomerDto;
import com.client.clientapi.exception.customer.CustomerNotFoundException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTestSuite {
    @Autowired
    private CustomerService service;

    @Test
    public void createCustomerTest() {
        CustomerDto customer = new CustomerDto();
        customer.setId(1L);
        customer.setFirstname("Chris");
        customer.setLastname("Mops");
        customer.setLogin("testLogin");
        customer.setPassword("123pwd");
        customer.setEmail("mail@mail.com");
        customer.setPhoneNumber("123-123-123");

        CustomerDto test = service.createCustomer(customer);
        Long id = test.getId();

        Assert.assertNotNull(service.getCustomerById(id));

        service.deleteCustomer(id);
    }

    @Test
    public void updateCustomerTest() {
        CustomerDto customer = new CustomerDto();
        customer.setId(1L);
        customer.setFirstname("Chris");
        customer.setLastname("Mops");
        customer.setLogin("testLogin");
        customer.setPassword("123pwd");
        customer.setEmail("mail@mail.com");
        customer.setPhoneNumber("123-123-123");

        CustomerDto customer2 = new CustomerDto();
        customer2.setFirstname("Chris");
        customer2.setLastname("Mops");
        customer2.setLogin("newLogin");
        customer2.setPassword("123pwd");
        customer2.setEmail("mail@mail.com");
        customer2.setPhoneNumber("123-123-123");

        CustomerDto test = service.createCustomer(customer);
        Long id = test.getId();

        customer2.setId(id);

        service.updateCustomer(customer2);

        Assert.assertNotEquals(customer.getLogin(), customer2.getLogin());

        service.deleteCustomer(id);
    }

    @Test(expected = CustomerNotFoundException.class)
    public void deleteCustomerThrowCustomerNotFoundExceptionTest() {
        Long id = 535235253L;
        service.deleteCustomer(id);
    }

    @Test
    public void validateCustomerAndReturnIdTest() {
        CustomerDto customer = new CustomerDto();
        customer.setId(1L);
        customer.setFirstname("Chris");
        customer.setLastname("Mops");
        customer.setLogin("testLogin");
        customer.setPassword("123pwd");
        customer.setEmail("mail@mail.com");
        customer.setPhoneNumber("123-123-123");

        CustomerDto test = service.createCustomer(customer);
        Long id = test.getId();

        Long returnedId = service.validateCustomerAndReturnId(customer.getLogin(), customer.getPassword());

        Assert.assertEquals(id, returnedId);

        service.deleteCustomer(id);
    }

    @Test
    public void validateCustomerAndReturnNullTest() {
        CustomerDto customer = new CustomerDto();
        customer.setId(1L);
        customer.setFirstname("Chris");
        customer.setLastname("Mops");
        customer.setLogin("testLogin");
        customer.setPassword("123pwd");
        customer.setEmail("mail@mail.com");
        customer.setPhoneNumber("123-123-123");

        String login = "GSDFGSDF!R1d12!@#53FERW";

        CustomerDto test = service.createCustomer(customer);
        Long id = test.getId();

        Long returnedId = service.validateCustomerAndReturnId(login, customer.getPassword());

        Assert.assertNotEquals(id, returnedId);

        service.deleteCustomer(id);
    }

    @Test
    public void validateCustomerLoginWhenExistTest() {
        CustomerDto customer = new CustomerDto();
        customer.setId(1L);
        customer.setFirstname("Chris");
        customer.setLastname("Mops");
        customer.setLogin("testLogin");
        customer.setPassword("123pwd");
        customer.setEmail("mail@mail.com");
        customer.setPhoneNumber("123-123-123");

        CustomerDto test = service.createCustomer(customer);
        Long id = test.getId();

        Boolean isExist = service.validateCustomerLogin(customer.getLogin());

        Assert.assertTrue(isExist);

        service.deleteCustomer(id);
    }

    @Test
    public void validateCustomerLoginWhenNotExistTest() {
        String login = "DAS1t3GG@e2FC!#f!!2dsdGV!#T1";

        Boolean isExist = service.validateCustomerLogin(login);

        Assert.assertFalse(isExist);
    }
}
