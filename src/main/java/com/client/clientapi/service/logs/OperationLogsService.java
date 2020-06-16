package com.client.clientapi.service.logs;

import com.client.clientapi.client.IpifyClient;
import com.client.clientapi.domain.logs.OperationLogs;
import com.client.clientapi.repository.logs.OperationLogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperationLogsService {
    private OperationLogsRepository repository;
    private IpifyClient ipifyClient;

    @Autowired
    public OperationLogsService(OperationLogsRepository repository, IpifyClient ipifyClient) {
        this.repository = repository;
        this.ipifyClient = ipifyClient;
    }

    public void createOperationLogs(OperationLogs operationLogs) {
        operationLogs.setId(null);
        operationLogs.setIpAddress(ipifyClient.getIp().toString()
                .replace("ipAddress", "")
                .replace("IpifyDto", "")
                .replace("(", "")
                .replace(")", "")
                .replace("=", ""));
        repository.save(operationLogs);
    }
}
