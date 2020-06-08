package com.client.clientapi.mapper;

import com.client.clientapi.domain.Customer;
import com.client.clientapi.domain.CustomerDto;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CustomerMapperTestSuite {
    private CustomerMapper mapper = new CustomerMapper();
    @Test
    public void testDtoToMap() {
        CustomerDto customerDto = new CustomerDto(1L, "Chris", "Mops", "pwd123", "mail@mail.com", "123-123-123");
        Customer customer= mapper.map(customerDto);

        Assert.assertEquals(customer.getId(), customerDto.getId());
        Assert.assertEquals(customer.getFirstname(), customerDto.getFirstname());
        Assert.assertEquals(customer.getLastname(), customerDto.getLastname());
        Assert.assertEquals(customer.getEmail(), customerDto.getEmail());
        Assert.assertEquals(customer.getPhoneNumber(), customerDto.getPhoneNumber());
        Assert.assertEquals(customer.getPassword(), customerDto.getPassword());
    }

    @Test
    public void testMapToDto() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setFirstname("Chris");
        customer.setLastname("Mops");
        customer.setPassword("123pwd");
        customer.setEmail("mail@mail.com");
        customer.setPhoneNumber("123-123-123");
        CustomerDto customerDto = mapper.mapToDto(customer);

        Assert.assertEquals(customerDto.getId(), customer.getId());
        Assert.assertEquals(customerDto.getFirstname(), customer.getFirstname());
        Assert.assertEquals(customerDto.getLastname(), customer.getLastname());
        Assert.assertEquals(customerDto.getEmail(), customer.getEmail());
        Assert.assertEquals(customerDto.getPhoneNumber(), customer.getPhoneNumber());
        Assert.assertEquals(customerDto.getPassword(), customer.getPassword());

    }

    @Test
    public void testToList() {
        Customer customer1 = new Customer();
        customer1.setId(1L);
        customer1.setFirstname("Chris");
        customer1.setLastname("Mops");
        customer1.setPassword("123pwd");
        customer1.setEmail("mail@mail.com");
        customer1.setPhoneNumber("123-123-123");

        List<Customer> customerList = new ArrayList<>();
        customerList.add(customer1);

        List<CustomerDto> customerDtoList = mapper.list(customerList);

        Assert.assertEquals(1, customerDtoList.size());
    }
}
