package com.client.clientapi.service;

import com.client.clientapi.domain.Clinic;
import com.client.clientapi.domain.Operation;
import com.client.clientapi.domain.OperationDto;
import com.client.clientapi.mapper.OperationMapper;
import com.client.clientapi.repository.OperationRepository;
import com.client.clientapi.repository.ClinicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OperationService {
    private OperationRepository repository;
    private OperationMapper mapper;
    private ClinicRepository clinicRepository;

    @Autowired
    public OperationService(OperationRepository repository, OperationMapper mapper, ClinicRepository clinicRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.clinicRepository = clinicRepository;
    }

    public List<OperationDto> getSpecializations() {
        return mapper.list(repository.findAll());
    }

    public OperationDto getSpecializationById(final Long id) {
        Optional<Operation> operations = repository.findById(id);
        return mapper.mapToDto(operations.orElse(null));
    }

    public OperationDto createSpecialization(final OperationDto operationDto) {
        operationDto.setId(null);
        Clinic clinic = clinicRepository.findById(operationDto.getClinic_id()).orElse(null);
        Operation operation = mapper.map(operationDto, clinic);
        return mapper.mapToDto(repository.save(operation));
    }

    public void deleteSpecialization(final Long id) {
        repository.deleteById(id);
    }

    public OperationDto updateSpecialization(final OperationDto operationDto) {
        repository.findById(operationDto.getId()).orElse(null);
        Clinic clinic = clinicRepository.findById(operationDto.getClinic_id()).orElse(null);
        return mapper.mapToDto(repository.save(mapper.map(operationDto, clinic)));
    }
}