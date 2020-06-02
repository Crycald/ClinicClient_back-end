package com.client.clientapi.domain;

import com.client.clientapi.domain.enums.Operations;
import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ClinicOperationsDto {
    private Long id;
    private Long clinic_id;
    private Operations operations;
    private BigDecimal cost;
}
