package com.client.clientapi.controller;

import com.client.clientapi.domain.CustomerDto;
import com.client.clientapi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client/customers")
@CrossOrigin("*")
public class CustomerController {
    private final CustomerService service;

    @Autowired
    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping(value = "/getCustomers")
    public List<CustomerDto> getCustomers() {
        return service.getCustomers();
    }

    @GetMapping(value = "/getCustomer")
    public CustomerDto getCustomerById(@RequestParam Long id) {
        return service.getCustomerById(id);
    }

    @PostMapping(value = "/createCustomer")
    public CustomerDto createCustomer(@RequestBody CustomerDto customerDto) {
        return service.createCustomer(customerDto);
    }

    @DeleteMapping(value = "/deleteCustomer")
    public void deleteCustomer(@RequestParam Long id) {
        service.deleteCustomer(id);
    }

    @PutMapping(value = "/updateCustomer")
    public CustomerDto updateCustomer(@RequestBody CustomerDto customerDto) {
        return service.updateCustomer(customerDto);
    }
}
