package com.client.clientapi.repository.logs;

import com.client.clientapi.domain.logs.ClinicLogs;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ClinicLogsRepository extends CrudRepository<ClinicLogs, Long> {
    @Override
    ClinicLogs save(ClinicLogs logs);
}