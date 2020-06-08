package com.client.clientapi.mapper;

import com.client.clientapi.domain.Clinic;
import com.client.clientapi.domain.Operation;
import com.client.clientapi.domain.OperationDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OperationMapper {
    public Operation map(final OperationDto operationDto, final Clinic clinic) {
        return Operation.builder()
                .id(operationDto.getId())
                .clinic_id(clinic)
                .operations(operationDto.getOperations())
                .cost(operationDto.getCost())
                .build();
    }

    public OperationDto mapToDto(final Operation operation) {
        return new OperationDto(
                operation.getId(),
                operation.getClinic_id().getId(),
                operation.getOperations(),
                operation.getCost()
        );
    }

    public List<OperationDto> list(final List<Operation> operationList) {
        return operationList.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }
}
