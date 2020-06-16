package com.client.clientapi.service.logs;

import com.client.clientapi.client.IpifyClient;
import com.client.clientapi.domain.logs.ClinicLogs;
import com.client.clientapi.repository.logs.ClinicLogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClinicLogsService {
    private ClinicLogsRepository repository;
    private IpifyClient ipifyClient;

    @Autowired
    public ClinicLogsService(ClinicLogsRepository repository, IpifyClient ipifyClient) {
        this.repository = repository;
        this.ipifyClient = ipifyClient;
    }

    public void createClinicLogs(ClinicLogs clinicLogs) {
        clinicLogs.setId(null);
        clinicLogs.setIpAddress(ipifyClient.getIp().toString()
                .replace("ipAddress", "")
                .replace("IpifyDto", "")
                .replace("(", "")
                .replace(")", "")
                .replace("=", ""));
        repository.save(clinicLogs);
    }
}