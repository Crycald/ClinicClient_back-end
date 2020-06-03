package com.client.clientapi.service;

import com.client.clientapi.domain.OperationAct;
import com.client.clientapi.domain.OperationActDto;
import com.client.clientapi.mapper.ClinicOperationsMapper;
import com.client.clientapi.repository.ClinicOperationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClinicOperationsService {
    private ClinicOperationsRepository repository;
    private ClinicOperationsMapper mapper;

    @Autowired
    public ClinicOperationsService(ClinicOperationsRepository repository, ClinicOperationsMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<OperationActDto> getSpecializations() {
        return mapper.list(repository.findAll());
    }

    public OperationActDto getSpecializationById(final Long id) {
        Optional<OperationAct> operations = repository.findById(id);
        return mapper.mapToDto(operations.orElse(null));
    }

    public OperationActDto createSpecialization(final OperationActDto operationActDto) {
        operationActDto.setId(null);
        OperationAct operationAct = mapper.map(operationActDto);
        return mapper.mapToDto(repository.save(operationAct));
    }

    public void deleteSpecialization(final Long id) {
        repository.deleteById(id);
    }

    public OperationActDto updateSpecialization(final OperationActDto operationActDto) {
        repository.findById(operationActDto.getId()).orElse(null);
        return mapper.mapToDto(repository.save(mapper.map(operationActDto)));
    }
}