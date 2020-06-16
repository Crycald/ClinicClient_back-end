package com.client.clientapi.domain;

import com.client.clientapi.domain.enums.TypeOfAnimal;
import com.client.clientapi.domain.logs.ClinicLogs;
import com.client.clientapi.domain.logs.OperationConnectorLogs;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "CLINICS")
public class Clinic {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "ID")
    private Long id;

    @Column(name = "COMPANY_NAME", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE_OF_ANIMAL", nullable = false)
    private TypeOfAnimal typeOfAnimal;

    @Column(name = "ADDRESS", nullable = false)
    private String address;

    @Column(name = "NIP", nullable = false)
    private Long nip;

    @Column(name = "PHONE_NUMBER", nullable = false)
    private String phoneNumber;

    @Column(name = "EMAIL", nullable = false)
    private String mail;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @OneToMany(
            targetEntity = Operation.class,
            mappedBy = "clinic_id",
            cascade = CascadeType.REMOVE,
            fetch = FetchType.LAZY
    )
    private List<Operation> listOfAvailableOperations = new ArrayList<>();

    @OneToMany(
            targetEntity = OperationConnector.class,
            mappedBy = "clinicId",
            cascade = CascadeType.REMOVE,
            fetch = FetchType.LAZY
    )
    private List<OperationConnector> listOfOperations = new ArrayList<>();

    @OneToMany(
            mappedBy = "clinicId",
            cascade = CascadeType.REMOVE
    )
    private List<ClinicLogs> clinicLogs = new ArrayList<>();

    @OneToMany(
            mappedBy = "clinicId",
            cascade = CascadeType.REMOVE
    )
    private List<OperationConnectorLogs> operationConnectorLogs = new ArrayList<>();
}