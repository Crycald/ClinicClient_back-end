package com.client.clientapi.service.logs;

import com.client.clientapi.domain.logs.ClinicLogs;
import com.client.clientapi.repository.logs.ClinicLogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClinicLogsService {
    private ClinicLogsRepository repository;

    @Autowired
    public ClinicLogsService(ClinicLogsRepository repository) {
        this.repository = repository;
    }

    public void createClinicLogs(ClinicLogs clinicLogs) {
        clinicLogs.setId(null);
        repository.save(clinicLogs);
    }
}