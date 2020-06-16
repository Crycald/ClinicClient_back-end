package com.client.clientapi.service.logs;

import com.client.clientapi.domain.logs.CustomerLogs;
import com.client.clientapi.repository.logs.CustomerLogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerLogsService {
    private CustomerLogsRepository repository;

    @Autowired
    public CustomerLogsService(CustomerLogsRepository repository) {
        this.repository = repository;
    }

    public void createCustomerLogs(CustomerLogs customerLogs) {
        customerLogs.setId(null);
        repository.save(customerLogs);
    }
}
