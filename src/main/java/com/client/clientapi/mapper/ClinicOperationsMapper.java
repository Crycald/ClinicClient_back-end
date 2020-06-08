package com.client.clientapi.mapper;

import com.client.clientapi.domain.Clinic;
import com.client.clientapi.domain.OperationAct;
import com.client.clientapi.domain.OperationActDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClinicOperationsMapper {
    public OperationAct map(final OperationActDto operationActDto, final Clinic clinic) {
        return OperationAct.builder()
                .id(operationActDto.getId())
                .clinic_id(clinic)
                .operations(operationActDto.getOperations())
                .cost(operationActDto.getCost())
                .build();
    }

    public OperationActDto mapToDto(final OperationAct operationAct) {
        return new OperationActDto(
                operationAct.getId(),
                operationAct.getClinic_id().getId(),
                operationAct.getOperations(),
                operationAct.getCost()
        );
    }

    public List<OperationActDto> list(final List<OperationAct> operationActList) {
        return operationActList.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }
}
