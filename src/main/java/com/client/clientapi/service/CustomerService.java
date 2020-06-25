package com.client.clientapi.service;

import com.client.clientapi.domain.Customer;
import com.client.clientapi.domain.CustomerDto;
import com.client.clientapi.domain.logs.CustomerLogs;
import com.client.clientapi.exception.customer.CustomerNotFoundException;
import com.client.clientapi.mapper.CustomerMapper;
import com.client.clientapi.repository.CustomerRepository;
import com.client.clientapi.service.logs.CustomerLogsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private CustomerRepository repository;
    private CustomerMapper mapper;
    private CustomerLogsService customerLogsService;
    private Logger logger = LoggerFactory.getLogger(CustomerService.class);

    @Autowired
    public CustomerService(CustomerRepository repository, CustomerMapper mapper, CustomerLogsService customerLogsService) {
        this.repository = repository;
        this.mapper = mapper;
        this.customerLogsService = customerLogsService;
    }

    public List<CustomerDto> getCustomers() {
        return mapper.list(repository.findAll());
    }

    public CustomerDto getCustomerById(final Long id) {
        Optional<Customer> customer = repository.findById(id);
        return mapper.mapToDto(customer.orElseThrow(() -> new CustomerNotFoundException(id)));
    }

    public CustomerDto createCustomer(final CustomerDto customerDto) {
        customerDto.setId(null);
        Customer customer = mapper.map(customerDto);
        mapper.mapToDto(repository.save(customer));

        CustomerLogs customerLogs = new CustomerLogs();
        customerLogs.setCustomerId(customer);
        customerLogs.setOperation("CREATE");
        customerLogs.setLastnameNew(customer.getLastname());
        customerLogs.setPasswordNew(customer.getPassword());
        customerLogs.setEmailNew(customer.getEmail());
        customerLogs.setPhoneNumberNew(customer.getPhoneNumber());
        customerLogsService.createCustomerLogs(customerLogs);

        logger.info("CUSTOMER CREATED - ID: " + customer.getId());

        return mapper.mapToDto(customer);
    }

    public void deleteCustomer(final Long id) {
        try {
            repository.deleteById(id);
            logger.info("CUSTOMER DELETED - ID: " + id);
        } catch (Exception e) {
            logger.warn("NOT FOUND CUSTOMER WITH ID: " + id);
            throw new CustomerNotFoundException(id);
        }
    }

    public CustomerDto updateCustomer(final CustomerDto customerDto) {
        Customer customer = repository.findById(customerDto.getId()).orElseThrow(() -> new CustomerNotFoundException(customerDto.getId()));

        CustomerLogs customerLogs = new CustomerLogs();
        customerLogs.setCustomerId(customer);
        customerLogs.setOperation("UPDATE");

        customerLogs.setLastnameOld(customer.getLastname());
        customerLogs.setPasswordOld(customer.getPassword());
        customerLogs.setEmailOld(customer.getEmail());
        customerLogs.setPhoneNumberOld(customer.getPhoneNumber());

        customerLogs.setLastnameNew(customerDto.getLastname());
        customerLogs.setPasswordNew(customerDto.getPassword());
        customerLogs.setEmailNew(customerDto.getEmail());
        customerLogs.setPhoneNumberNew(customerDto.getPhoneNumber());
        customerLogsService.createCustomerLogs(customerLogs);

        logger.info("CUSTOMER UPDATED - ID: " + customer.getId());

        return mapper.mapToDto(repository.save(mapper.map(customerDto)));
    }

    public Long validateCustomerAndReturnId(final String login, final String password) {
        Optional<Customer> customer = repository.findByLoginAndPassword(login, password);

        if (customer.isPresent()) {
            logger.info("USER HAS BEEN FOUND");
            System.out.println("Customer ID: " + customer.get().getId());
            return customer.get().getId();
        } else {
            logger.warn("USER NOT FOUND");
            return null;
        }
    }

    public Boolean validateCustomerLogin(final String login) {
        Optional<Customer> customer = repository.findByLogin(login);

        if (customer.isPresent()) {
            logger.info("CUSTOMER WITH GIVEN LOGIN EXISTS");
            return true;
        } else {
            logger.warn("USER NOT FOUND");
            return false;
        }
    }
}
