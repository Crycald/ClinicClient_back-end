package com.client.clientapi.domain.logs;

import com.client.clientapi.domain.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "CUSTOMER_AUD")
public class CustomerLogs {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customerId;

    @Column(name = "IP_ADDRESS")
    private String ipAddress;

    @Column(name = "OPERATION")
    private String operation;

    @Column(name = "DATE")
    private final LocalDateTime date = LocalDateTime.now();
}
