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
    private Long customerId;
    private Long operationActId;
    private final LocalDate date = LocalDate.now();
}
