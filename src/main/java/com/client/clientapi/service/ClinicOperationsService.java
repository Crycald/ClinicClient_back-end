package com.client.clientapi.service;

import com.client.clientapi.domain.Clinic;
import com.client.clientapi.domain.OperationAct;
import com.client.clientapi.domain.OperationActDto;
import com.client.clientapi.mapper.ClinicOperationsMapper;
import com.client.clientapi.repository.ClinicOperationActRepository;
import com.client.clientapi.repository.ClinicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClinicOperationsService {
    private ClinicOperationActRepository repository;
    private ClinicOperationsMapper mapper;
    private ClinicRepository clinicRepository;

    @Autowired
    public ClinicOperationsService(ClinicOperationActRepository repository, ClinicOperationsMapper mapper, ClinicRepository clinicRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.clinicRepository = clinicRepository;
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
        Clinic clinic = clinicRepository.findById(operationActDto.getClinic_id()).orElse(null);
        OperationAct operationAct = mapper.map(operationActDto, clinic);
        return mapper.mapToDto(repository.save(operationAct));
    }

    public void deleteSpecialization(final Long id) {
        repository.deleteById(id);
    }

    public OperationActDto updateSpecialization(final OperationActDto operationActDto) {
        repository.findById(operationActDto.getId()).orElse(null);
        Clinic clinic = clinicRepository.findById(operationActDto.getClinic_id()).orElse(null);
        return mapper.mapToDto(repository.save(mapper.map(operationActDto, clinic)));
    }
}