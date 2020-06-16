package com.client.clientapi.domain;

import com.client.clientapi.domain.logs.OperationConnectorLogs;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "OPERATION_CONNECTOR")
public class OperationConnector {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "CLINIC_ID")
    private Clinic clinicId;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customerId;

    @ManyToOne
    @JoinColumn(name = "OPERATION_ID")
    private Operation operationId;

    @Column(name = "DATE")
    private LocalDate date;

    @OneToMany(
            mappedBy = "operationConnectorId",
            cascade = CascadeType.REMOVE
    )
    private List<OperationConnectorLogs> operationConnectorLogs = new ArrayList<>();
}
