package com.client.clientapi.service;

import com.client.clientapi.domain.*;
import com.client.clientapi.exception.clinic.ClinicNotFoundException;
import com.client.clientapi.exception.connector.OperationConnectorNotFoundException;
import com.client.clientapi.exception.customer.CustomerNotFoundException;
import com.client.clientapi.exception.operation.OperationNotFoundException;
import com.client.clientapi.mapper.OperationConnectorMapper;
import com.client.clientapi.repository.OperationRepository;
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
    private OperationRepository operationRepository;

    @Autowired
    public OperationConnectorService(OperationConnectorMapper mapper, OperationConnectorRepository repository, ClinicRepository clinicRepository, CustomerRepository customerRepository, OperationRepository operationRepository) {
        this.mapper = mapper;
        this.repository = repository;
        this.clinicRepository = clinicRepository;
        this.customerRepository = customerRepository;
        this.operationRepository = operationRepository;
    }

    public List<OperationConnectorDto> getOperationConnectors() {
        return mapper.list(repository.findAll());
    }

    public OperationConnectorDto getOperationConnectorById(final Long id) {
        Optional<OperationConnector> operationConnector = repository.findById(id);
        return mapper.mapToDto(operationConnector.orElseThrow(() -> new OperationConnectorNotFoundException(id)));
    }

    public OperationConnectorDto createOperationConnector(final OperationConnectorDto operationConnectorDto) {
        operationConnectorDto.setId(null);
        Clinic clinic = clinicRepository.findById(operationConnectorDto.getClinicId()).orElseThrow(() -> new ClinicNotFoundException(operationConnectorDto.getClinicId()));
        Customer customer = customerRepository.findById(operationConnectorDto.getCustomerId()).orElseThrow(() -> new CustomerNotFoundException(operationConnectorDto.getCustomerId()));
        Operation operation = operationRepository.findById(operationConnectorDto.getOperationActId()).orElseThrow(() -> new OperationNotFoundException(operationConnectorDto.getOperationActId()));
        OperationConnector operationConnector = mapper.map(operationConnectorDto, clinic, customer, operation);
        return mapper.mapToDto(repository.save(operationConnector));
    }

    public void deleteOperationConnector(final Long id) {
        repository.deleteById(id);
    }

    public OperationConnectorDto updateOperationConnector(final OperationConnectorDto operationConnectorDto) {
        repository.findById(operationConnectorDto.getId()).orElseThrow(() -> new OperationConnectorNotFoundException(operationConnectorDto.getId()));
        Clinic clinic = clinicRepository.findById(operationConnectorDto.getClinicId()).orElseThrow(() -> new ClinicNotFoundException(operationConnectorDto.getClinicId()));
        Customer customer = customerRepository.findById(operationConnectorDto.getCustomerId()).orElseThrow(() -> new CustomerNotFoundException(operationConnectorDto.getCustomerId()));
        Operation operation = operationRepository.findById(operationConnectorDto.getOperationActId()).orElseThrow(() -> new OperationNotFoundException(operationConnectorDto.getOperationActId()));
        return mapper.mapToDto(repository.save(mapper.map(operationConnectorDto, clinic, customer, operation)));
    }
}
