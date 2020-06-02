package com.client.clientapi.service;

import com.client.clientapi.domain.Customer;
import com.client.clientapi.domain.CustomerDto;
import com.client.clientapi.mapper.CustomerMapper;
import com.client.clientapi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private CustomerRepository repository;
    private CustomerMapper mapper;

    @Autowired
    public CustomerService(CustomerRepository repository, CustomerMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<CustomerDto> getCustomers() {
        return mapper.list(repository.findAll());
    }

    public CustomerDto getCustomerById(final Long id) {
        Optional<Customer> customer = repository.findById(id);
        return mapper.mapToDto(customer.orElse(null));
    }

    public CustomerDto createCustomer(final CustomerDto customerDto) {
        customerDto.setId(null);
        Customer customer = mapper.map(customerDto);
        return mapper.mapToDto(repository.save(customer));
    }

    public void deleteCustomer(final Long id) {
        repository.deleteById(id);
    }

    public CustomerDto updateCustomer(final CustomerDto customerDto) {
        repository.findById(customerDto.getId()).orElse(null);
        return mapper.mapToDto(repository.save(mapper.map(customerDto)));
    }
}
