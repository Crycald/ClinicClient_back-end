package com.client.clientapi.domain;

import com.client.clientapi.domain.logs.CustomerLogs;
import com.client.clientapi.domain.logs.OperationConnectorLogs;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "CUSTOMERS")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "ID")
    private Long id;

    @Column(name = "FIRST_NAME", nullable = false)
    private String firstname;

    @Column(name = "LAST_NAME", nullable = false)
    private String lastname;

    @Column(name = "LOGIN", nullable = false)
    private String login;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "PHONE_NUMBER", nullable = false)
    private String phoneNumber;

    @OneToMany(
            targetEntity = OperationConnector.class,
            mappedBy = "customerId",
            cascade = CascadeType.REMOVE,
            fetch = FetchType.EAGER
    )
    private List<OperationConnector> listOfOperations = new ArrayList<>();

    @OneToMany(
            mappedBy = "customerId",
            cascade = CascadeType.REMOVE
    )
    private List<CustomerLogs> customerLogs = new ArrayList<>();

    @OneToMany(
            mappedBy = "customerId",
            cascade = CascadeType.REMOVE
    )
    private List<OperationConnectorLogs> operationConnectorLogs = new ArrayList<>();
}
