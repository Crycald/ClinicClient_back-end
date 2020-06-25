package com.client.clientapi.controller;

import com.client.clientapi.domain.CustomerDto;
import com.client.clientapi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
@CrossOrigin("*")
public class CustomerController {
    private final CustomerService service;

    @Autowired
    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping(value = "/customers")
    public List<CustomerDto> getCustomers() {
        return service.getCustomers();
    }

    @GetMapping(value = "/customers/{id}")
    public CustomerDto getCustomerById(@PathVariable Long id) {
        return service.getCustomerById(id);
    }

    @PostMapping(value = "/customers")
    public void createCustomer(@RequestBody CustomerDto customerDto) {
        service.createCustomer(customerDto);
    }

    @DeleteMapping(value = "/customers/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        service.deleteCustomer(id);
    }

    @PutMapping(value = "/customers")
    public CustomerDto updateCustomer(@RequestBody CustomerDto customerDto) {
        return service.updateCustomer(customerDto);
    }

    @GetMapping(value = "/customers/validate/{login}&{password}")
    public Long validateUserAndReturnId(@PathVariable String login, @PathVariable String password) {
        return service.validateCustomerAndReturnId(login, password);
    }

    @GetMapping(value = "/customers/validateLogin/{login}")
    public Boolean validateCustomerLogin(@PathVariable String login) {
        return service.validateCustomerLogin(login);
    }
}
