package com.client.clientapi.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "OPERATION_CONNECTOR")
public class OperationConnector {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "CLINIC_ID", nullable = false)
    private Long clinicId;

    @Column(name = "CUSTOMER_ID", nullable = false)
    private Long customerId;

    @Column(name = "OPERATION_ACT_ID", nullable = false)
    private Long operationActId;

    @Column(name = "DATE")
    private LocalDate date;
}
