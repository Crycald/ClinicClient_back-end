package com.client.clientapi.repository.logs;

import com.client.clientapi.domain.logs.OperationConnectorLogs;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface OperationConnectorLogsRepository extends CrudRepository<OperationConnectorLogs, Long> {
    @Override
    OperationConnectorLogs save(OperationConnectorLogs logs);
}
