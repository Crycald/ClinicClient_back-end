package com.client.clientapi.mapper;

import com.client.clientapi.domain.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OperationConnectorMapper {

    public OperationConnector map(final OperationConnectorDto operationConnectorDto, final Clinic clinic, final Customer customer, final OperationAct operationAct) {
        return OperationConnector.builder()
                .id(operationConnectorDto.getId())
                .clinicId(clinic)
                .customerId(customer)
                .operationActId(operationAct)
                .date(operationConnectorDto.getDate())
                .build();
    }

    public OperationConnectorDto mapToDto(final OperationConnector operationConnector) {
        return new OperationConnectorDto(
                operationConnector.getId(),
                operationConnector.getClinicId().getId(),
                operationConnector.getCustomerId().getId(),
                operationConnector.getOperationActId().getId()
        );
    }

    public List<OperationConnectorDto> list(final List<OperationConnector> operationConnectorList) {
        return operationConnectorList.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }
}
