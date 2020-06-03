package com.client.clientapi.domain;

import com.client.clientapi.domain.enums.Operation;
import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class OperationActDto {
    private Long id;
    private Long clinic_id;
    private Operation operations;
    private BigDecimal cost;
}
