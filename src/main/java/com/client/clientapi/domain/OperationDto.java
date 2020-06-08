package com.client.clientapi.domain;

import com.client.clientapi.domain.enums.TypeOfOperation;
import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class OperationDto {
    private Long id;
    private Long clinic_id;
    private TypeOfOperation operations;
    private BigDecimal cost;
}
