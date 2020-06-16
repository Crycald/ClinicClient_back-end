package com.client.clientapi.repository.logs;

import com.client.clientapi.domain.logs.CustomerLogs;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface CustomerLogsRepository extends CrudRepository<CustomerLogs, Long> {
    @Override
    CustomerLogs save(CustomerLogs logs);
}
