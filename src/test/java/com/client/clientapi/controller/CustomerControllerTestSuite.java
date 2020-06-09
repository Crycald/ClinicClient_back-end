package com.client.clientapi.controller;

import com.client.clientapi.domain.Customer;
import com.client.clientapi.domain.CustomerDto;
import com.client.clientapi.service.CustomerService;
import com.google.gson.Gson;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTestSuite {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    private CustomerService service;

    @Test
    public void shouldFetchEmptyCustomerList() throws Exception {
        List<CustomerDto> customerDtoList = new ArrayList<>();

        when(service.getCustomers()).thenReturn(customerDtoList);

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/customers").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(0)));
    }

    @Test
    public void shouldFetchCustomerList() throws Exception {
        List<CustomerDto> customer = new ArrayList<>();
        customer.add(new CustomerDto(1L, "first", "last", "pwd", "@@@@", "123-123-123"));

        when(service.getCustomers()).thenReturn(customer);

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/customers").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())

                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].firstname", Matchers.is("first")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].lastname", Matchers.is("last")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].password", Matchers.is("pwd")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].email", Matchers.is("@@@@")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].phoneNumber", Matchers.is("123-123-123")));

    }

    @Test
    public void shouldFetchCustomerById() throws Exception {
        CustomerDto customerDto = new CustomerDto(1L, "first", "last", "pwd", "@@@@", "123-123-123");
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setFirstname("first");
        customer.setLastname("last");
        customer.setPassword("pwd");
        customer.setEmail("@@@@");
        customer.setPhoneNumber("123-123-123");

        when(service.getCustomerById(1L)).thenReturn(customerDto);

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/customers/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstname", Matchers.is("first")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastname", Matchers.is("last")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.password", Matchers.is("pwd")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email", Matchers.is("@@@@")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.phoneNumber", Matchers.is("123-123-123")));
    }

    @Test
    public void shouldDeleteCustomerById() throws Exception {
        CustomerDto customerDto = new CustomerDto(1L, "first", "last", "pwd", "@@@@", "123-123-123");
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setFirstname("first");
        customer.setLastname("last");
        customer.setPassword("pwd");
        customer.setEmail("@@@@");
        customer.setPhoneNumber("123-123-123");

        when(service.getCustomerById(1L)).thenReturn(customerDto);

        mockMvc.perform(MockMvcRequestBuilders.delete("/v1/customers/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void shouldUpdateCustomer() throws Exception {
        CustomerDto customerDto = new CustomerDto(1L, "first", "last", "pwd", "@@@@", "123-123-123");
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setFirstname("first");
        customer.setLastname("last");
        customer.setPassword("pwd");
        customer.setEmail("@@@@");
        customer.setPhoneNumber("123-123-123");

        when(service.updateCustomer(ArgumentMatchers.any())).thenReturn(customerDto);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(customerDto);

        mockMvc.perform(MockMvcRequestBuilders.put("/v1/customers")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))

                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstname", Matchers.is("first")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastname", Matchers.is("last")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.password", Matchers.is("pwd")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email", Matchers.is("@@@@")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.phoneNumber", Matchers.is("123-123-123")));
        
    }
}
