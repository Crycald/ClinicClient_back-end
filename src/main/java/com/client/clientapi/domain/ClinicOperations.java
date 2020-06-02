package com.client.clientapi.domain;

import com.client.clientapi.domain.enums.Operation;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Data
@Entity
@Table(name = "CLINIC_OPERATIONS")
public class ClinicOperations {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "CLINIC_ID", nullable = false)
    private Long clinic_id;

    @Column(name = "OPERATIONS", nullable = false)
    private Operation operations;

    @Column(name = "COST")
    private BigDecimal cost;
}
