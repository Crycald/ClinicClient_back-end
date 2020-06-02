package com.client.clientapi.service;

import com.client.clientapi.domain.ClinicOperations;
import com.client.clientapi.domain.ClinicOperationsDto;
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

    public List<ClinicOperationsDto> getSpecializations() {
        return mapper.list(repository.findAll());
    }

    public ClinicOperationsDto getSpecializationById(final Long id) {
        Optional<ClinicOperations> operations = repository.findById(id);
        return mapper.mapToDto(operations.orElse(null));
    }

    public ClinicOperationsDto createSpecialization(final ClinicOperationsDto clinicOperationsDto) {
        clinicOperationsDto.setId(null);
        ClinicOperations clinicOperations = mapper.map(clinicOperationsDto);
        return mapper.mapToDto(repository.save(clinicOperations));
    }

    public void deleteSpecialization(final Long id) {
        repository.deleteById(id);
    }

    public ClinicOperationsDto updateSpecialization(final ClinicOperationsDto clinicOperationsDto) {
        repository.findById(clinicOperationsDto.getId()).orElse(null);
        return mapper.mapToDto(repository.save(mapper.map(clinicOperationsDto)));
    }
}