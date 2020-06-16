package com.client.clientapi.service.logs;

import com.client.clientapi.domain.logs.OperationLogs;
import com.client.clientapi.repository.logs.OperationLogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperationLogsService {
    private OperationLogsRepository repository;

    @Autowired
    public OperationLogsService(OperationLogsRepository repository) {
        this.repository = repository;
    }

    public void createOperationLogs(OperationLogs operationLogs) {
        operationLogs.setId(null);
        repository.save(operationLogs);
    }
}
