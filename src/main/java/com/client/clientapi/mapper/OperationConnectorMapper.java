package com.client.clientapi.mapper;

import com.client.clientapi.domain.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OperationConnectorMapper {

    public OperationConnector map(final OperationConnectorDto operationConnectorDto, final Clinic clinic, final Customer customer, final Operation operation) {
        return OperationConnector.builder()
                .id(operationConnectorDto.getId())
                .clinicId(clinic)
                .customerId(customer)
                .operationId(operation)
                .date(operationConnectorDto.getDate())
                .build();
    }

    public OperationConnectorDto mapToDto(final OperationConnector operationConnector) {
        return new OperationConnectorDto(
                operationConnector.getId(),
                operationConnector.getClinicId().getId(),
                operationConnector.getClinicId().getName(),
                operationConnector.getClinicId().getAddress(),
                operationConnector.getCustomerId().getId(),
                operationConnector.getCustomerId().getFirstname(),
                operationConnector.getCustomerId().getLastname(),
                operationConnector.getCustomerId().getPhoneNumber(),
                operationConnector.getOperationId().getId(),
                operationConnector.getOperationId().getOperations().toString(),
                operationConnector.getOperationId().getCost().longValue(),
                operationConnector.getDate()
        );
    }

    public List<OperationConnectorDto> list(final List<OperationConnector> operationConnectorList) {
        return operationConnectorList.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }
}
