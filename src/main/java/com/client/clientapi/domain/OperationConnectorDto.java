package com.client.clientapi.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class OperationConnectorDto {
    private Long id;
    private Long clinicId;
    private String clinicName;
    private String clinicAddress;
    private Long customerId;
    private String customerFirstName;
    private String customerLastName;
    private String customerPhoneNumber;
    private Long operationActId;
    private String operationName;
    private Long operationCost;
    private LocalDate date;
}
