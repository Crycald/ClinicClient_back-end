package com.client.clientapi.service;

import com.client.clientapi.domain.Clinic;
import com.client.clientapi.domain.Operation;
import com.client.clientapi.domain.OperationDto;
import com.client.clientapi.domain.logs.OperationLogs;
import com.client.clientapi.exception.clinic.ClinicNotFoundException;
import com.client.clientapi.exception.operation.OperationNotFoundException;
import com.client.clientapi.mapper.OperationMapper;
import com.client.clientapi.repository.OperationRepository;
import com.client.clientapi.repository.ClinicRepository;
import com.client.clientapi.service.logs.OperationLogsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OperationService {
    private OperationRepository repository;
    private OperationMapper mapper;
    private ClinicRepository clinicRepository;
    private OperationLogsService operationLogsService;
    private Logger logger = LoggerFactory.getLogger(OperationService.class);

    @Autowired
    public OperationService(OperationRepository repository, OperationMapper mapper, ClinicRepository clinicRepository, OperationLogsService operationLogsService) {
        this.repository = repository;
        this.mapper = mapper;
        this.clinicRepository = clinicRepository;
        this.operationLogsService = operationLogsService;
    }

    public List<OperationDto> getSpecializations() {
        return mapper.list(repository.findAll());
    }

    public OperationDto getSpecializationById(final Long id) {
        Optional<Operation> operations = repository.findById(id);
        return mapper.mapToDto(operations.orElseThrow(() -> new OperationNotFoundException(id)));
    }

    public void createSpecialization(final OperationDto operationDto) {
        operationDto.setId(null);
        Clinic clinic = clinicRepository.findById(operationDto.getClinic_id()).orElseThrow(() -> new ClinicNotFoundException(operationDto.getClinic_id()));
        Operation operation = mapper.map(operationDto, clinic);
        mapper.mapToDto(repository.save(operation));

        OperationLogs operationLogs = new OperationLogs();
        operationLogs.setOperationId(operation);
        operationLogs.setOperation("CREATE");
        operationLogsService.createOperationLogs(operationLogs);

        logger.info("OPERATION CREATED - ID: " + operation.getId());
    }

    public void deleteSpecialization(final Long id) {
        try {
            repository.deleteById(id);
            logger.info("OPERATION DELETED - ID: " + id);
        } catch (Exception e) {
            logger.warn("NOT FOUND OPERATION WITH ID: " + id);
            throw new OperationNotFoundException(id);
        }
    }

    public OperationDto updateSpecialization(final OperationDto operationDto) {
        Operation operation = repository.findById(operationDto.getId()).orElseThrow(() -> new OperationNotFoundException(operationDto.getId()));
        Clinic clinic = clinicRepository.findById(operationDto.getClinic_id()).orElseThrow(() -> new ClinicNotFoundException(operationDto.getClinic_id()));

        OperationLogs operationLogs = new OperationLogs();
        operationLogs.setOperationId(operation);
        operationLogs.setOperation("UPDATE");
        operationLogsService.createOperationLogs(operationLogs);

        logger.info("OPERATION UPDATED - ID: " + operation.getId());

        return mapper.mapToDto(repository.save(mapper.map(operationDto, clinic)));
    }
}