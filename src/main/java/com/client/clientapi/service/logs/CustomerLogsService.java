package com.client.clientapi.service.logs;

import com.client.clientapi.client.IpifyClient;
import com.client.clientapi.domain.logs.CustomerLogs;
import com.client.clientapi.repository.logs.CustomerLogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerLogsService {
    private CustomerLogsRepository repository;
    private IpifyClient ipifyClient;

    @Autowired
    public CustomerLogsService(CustomerLogsRepository repository, IpifyClient ipifyClient) {
        this.repository = repository;
        this.ipifyClient = ipifyClient;
    }

    public void createCustomerLogs(CustomerLogs customerLogs) {
        customerLogs.setId(null);
        customerLogs.setIpAddress(ipifyClient.getIp().toString()
                .replace("ipAddress", "")
                .replace("IpifyDto", "")
                .replace("(", "")
                .replace(")", "")
                .replace("=", ""));
        repository.save(customerLogs);
    }
}
