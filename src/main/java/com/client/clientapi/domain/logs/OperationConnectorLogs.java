package com.client.clientapi.domain.logs;

import com.client.clientapi.domain.Clinic;
import com.client.clientapi.domain.Customer;
import com.client.clientapi.domain.Operation;
import com.client.clientapi.domain.OperationConnector;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "OPERATION_CONNECTOR_AUD")
public class OperationConnectorLogs {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "OPERATION_CONNECTOR_ID")
    private OperationConnector operationConnectorId;

    @ManyToOne
    @JoinColumn(name = "CLINIC_ID")
    private Clinic clinicId;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customerId;

    @ManyToOne
    @JoinColumn(name = "OPERATION_ID")
    private Operation operationId;

    @Column(name = "IP_ADDRESS")
    private String ipAddress;

    @Column(name = "OPERATION")
    private String operation;

    @Column(name = "DATE")
    private final LocalDateTime date = LocalDateTime.now();
}
