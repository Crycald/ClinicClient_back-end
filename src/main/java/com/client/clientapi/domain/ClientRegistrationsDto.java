package com.client.clientapi.domain;

import com.client.clientapi.domain.enums.Operations;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ClientRegistrationsDto {
    private Long id;
    private Long clinicId;
    private String clinicName;
    private Operations clinicOperation;
    private BigDecimal clinicOperationCost;
    private Date date;
}
