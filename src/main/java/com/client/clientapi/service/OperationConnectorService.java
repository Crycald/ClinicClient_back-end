package com.client.clientapi.service;

import com.client.clientapi.domain.*;
import com.client.clientapi.mapper.OperationConnectorMapper;
import com.client.clientapi.repository.ClinicOperationActRepository;
import com.client.clientapi.repository.ClinicRepository;
import com.client.clientapi.repository.CustomerRepository;
import com.client.clientapi.repository.OperationConnectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OperationConnectorService {
    private OperationConnectorMapper mapper;
    private OperationConnectorRepository repository;
    private ClinicRepository clinicRepository;
    private CustomerRepository customerRepository;
    private ClinicOperationActRepository clinicOperationActRepository;

    @Autowired
    public OperationConnectorService(OperationConnectorMapper mapper, OperationConnectorRepository repository, ClinicRepository clinicRepository, CustomerRepository customerRepository, ClinicOperationActRepository clinicOperationActRepository) {
        this.mapper = mapper;
        this.repository = repository;
        this.clinicRepository = clinicRepository;
        this.customerRepository = customerRepository;
        this.clinicOperationActRepository = clinicOperationActRepository;
    }

    public List<OperationConnectorDto> getOperationConnectors() {
        return mapper.list(repository.findAll());
    }

    public OperationConnectorDto getOperationConnectorById(final Long id) {
        Optional<OperationConnector> operationConnector = repository.findById(id);
        return mapper.mapToDto(operationConnector.orElse(null));
    }

    public OperationConnectorDto createOperationConnector(final OperationConnectorDto operationConnectorDto) {
        operationConnectorDto.setId(null);
        Clinic clinic = clinicRepository.findById(operationConnectorDto.getClinicId()).orElse(null);
        Customer customer = customerRepository.findById(operationConnectorDto.getCustomerId()).orElse(null);
        OperationAct operationAct = clinicOperationActRepository.findById(operationConnectorDto.getOperationActId()).orElse(null);
        OperationConnector operationConnector = mapper.map(operationConnectorDto, clinic, customer, operationAct);
        return mapper.mapToDto(repository.save(operationConnector));
    }

    public void deleteOperationConnector(final Long id) {
        repository.deleteById(id);
    }

    public OperationConnectorDto updateOperationConnector(final OperationConnectorDto operationConnectorDto) {
        repository.findById(operationConnectorDto.getId()).orElse(null);
        Clinic clinic = clinicRepository.findById(operationConnectorDto.getClinicId()).orElse(null);
        Customer customer = customerRepository.findById(operationConnectorDto.getCustomerId()).orElse(null);
        OperationAct operationAct = clinicOperationActRepository.findById(operationConnectorDto.getOperationActId()).orElse(null);
        return mapper.mapToDto(repository.save(mapper.map(operationConnectorDto, clinic, customer, operationAct)));
    }
}
