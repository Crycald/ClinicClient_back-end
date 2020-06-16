package com.client.clientapi.repository.logs;

import com.client.clientapi.domain.logs.OperationLogs;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface OperationLogsRepository extends CrudRepository<OperationLogs, Long> {
    @Override
    OperationLogs save(OperationLogs logs);
}
