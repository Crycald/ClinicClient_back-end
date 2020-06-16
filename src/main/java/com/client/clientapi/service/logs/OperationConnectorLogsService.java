package com.client.clientapi.service.logs;

import com.client.clientapi.domain.logs.OperationConnectorLogs;
import com.client.clientapi.repository.logs.OperationConnectorLogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperationConnectorLogsService {
    private OperationConnectorLogsRepository repository;

    @Autowired
    public OperationConnectorLogsService(OperationConnectorLogsRepository repository) {
        this.repository = repository;
    }

    public void createOperationConnectorLogs(OperationConnectorLogs operationConnectorLogs) {
        operationConnectorLogs.setId(null);
        repository.save(operationConnectorLogs);
    }
}
