package com.client.clientapi.mapper;

import com.client.clientapi.domain.ClinicOperations;
import com.client.clientapi.domain.ClinicOperationsDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClinicOperationsMapper {
    public ClinicOperations map(final ClinicOperationsDto clinicOperationsDto) {
        return ClinicOperations.builder()
                .id(clinicOperationsDto.getId())
                .clinic_id(clinicOperationsDto.getClinic_id())
                .operations(clinicOperationsDto.getOperations())
                .cost(clinicOperationsDto.getCost())
                .build();
    }

    public ClinicOperationsDto mapToDto(final ClinicOperations clinicOperations) {
        return new ClinicOperationsDto(
                clinicOperations.getId(),
                clinicOperations.getClinic_id(),
                clinicOperations.getOperations(),
                clinicOperations.getCost()
        );
    }

    public List<ClinicOperationsDto> list(final List<ClinicOperations> clinicOperationsList) {
        return clinicOperationsList.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }
}
