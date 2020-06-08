package com.client.clientapi.domain;

import com.client.clientapi.domain.enums.Operation;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "OPERATION_ACT")
public class OperationAct {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "CLINIC_ID")
    private Clinic clinic_id;

    @Enumerated(EnumType.STRING)
    @Column(name = "OPERATIONS", nullable = false)
    private Operation operations;

    @Column(name = "COST")
    private BigDecimal cost;

    @OneToMany(
            targetEntity = OperationConnector.class,
            mappedBy = "operationActId",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<OperationConnector> list = new ArrayList<>();
}
