package com.client.clientapi.service;

import com.client.clientapi.domain.Clinic;
import com.client.clientapi.domain.ClinicDto;
import com.client.clientapi.exception.clinic.ClinicNotFoundException;
import com.client.clientapi.mapper.ClinicMapper;
import com.client.clientapi.repository.ClinicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClinicService {
    private ClinicRepository repository;
    private ClinicMapper mapper;

    @Autowired
    public ClinicService(ClinicRepository repository, ClinicMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<ClinicDto> getClinics() {
        return mapper.list(repository.findAll());
    }

    public ClinicDto getClinicById(final Long id) {
        Optional<Clinic> clinic = repository.findById(id);
        return mapper.mapToDto(clinic.orElseThrow(() -> new ClinicNotFoundException(id)));
    }

    public ClinicDto createClinic(final ClinicDto clinicDto) {
        clinicDto.setId(null);
        Clinic clinic = mapper.map(clinicDto);
        return mapper.mapToDto(repository.save(clinic));
    }

    public void deleteClinic(final Long id) {
        repository.deleteById(id);
    }

    public ClinicDto updateClinic(final ClinicDto clinicDto) {
        repository.findById(clinicDto.getId()).orElseThrow(() -> new ClinicNotFoundException(clinicDto.getId()));
        return mapper.mapToDto(repository.save(mapper.map(clinicDto)));
    }
}
