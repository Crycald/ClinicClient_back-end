package com.client.clientapi.mapper;

import com.client.clientapi.domain.Customer;
import com.client.clientapi.domain.CustomerDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerMapper {
    public Customer map(final CustomerDto customerDto) {
        return Customer.builder()
                .id(customerDto.getId())
                .firstname(customerDto.getFirstname())
                .lastname(customerDto.getLastname())
                .login(customerDto.getLogin())
                .email(customerDto.getEmail())
                .password(customerDto.getPassword())
                .phoneNumber(customerDto.getPhoneNumber())
                .build();
    }

    public CustomerDto mapToDto(final Customer customer) {
        return new CustomerDto(
                customer.getId(),
                customer.getFirstname(),
                customer.getLastname(),
                customer.getLogin(),
                customer.getPassword(),
                customer.getEmail(),
                customer.getPhoneNumber()
        );
    }

    public List<CustomerDto> list(final List<Customer> customers) {
        return customers.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }
}
