package com.client.clientapi.service.logs;

import com.client.clientapi.client.IpifyClient;
import com.client.clientapi.domain.logs.OperationConnectorLogs;
import com.client.clientapi.repository.logs.OperationConnectorLogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperationConnectorLogsService {
    private OperationConnectorLogsRepository repository;
    private IpifyClient ipifyClient;

    @Autowired
    public OperationConnectorLogsService(OperationConnectorLogsRepository repository, IpifyClient ipifyClient) {
        this.repository = repository;
        this.ipifyClient = ipifyClient;
    }

    public void createOperationConnectorLogs(OperationConnectorLogs operationConnectorLogs) {
        operationConnectorLogs.setId(null);
        operationConnectorLogs.setIpAddress(ipifyClient.getIp().toString()
                .replace("ipAddress", "")
                .replace("IpifyDto", "")
                .replace("(", "")
                .replace(")", "")
                .replace("=", ""));
        repository.save(operationConnectorLogs);
    }
}
