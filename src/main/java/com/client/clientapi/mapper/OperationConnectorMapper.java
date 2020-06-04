package com.client.clientapi.mapper;

import com.client.clientapi.domain.OperationConnector;
import com.client.clientapi.domain.OperationConnectorDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OperationConnectorMapper {

    public OperationConnector map(final OperationConnectorDto operationConnectorDto) {
        return OperationConnector.builder()
                .id(operationConnectorDto.getId())
                .clinicId(operationConnectorDto.getClinicId())
                .customerId(operationConnectorDto.getCustomerId())
                .operationActId(operationConnectorDto.getOperationActId())
                .date(operationConnectorDto.getDate())
                .build();
    }

    public OperationConnectorDto mapToDto(final OperationConnector operationConnector) {
        return new OperationConnectorDto(
                operationConnector.getId(),
                operationConnector.getClinicId(),
                operationConnector.getCustomerId(),
                operationConnector.getOperationActId()
        );
    }

    public List<OperationConnectorDto> list(final List<OperationConnector> operationConnectorList) {
        return operationConnectorList.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }
}
