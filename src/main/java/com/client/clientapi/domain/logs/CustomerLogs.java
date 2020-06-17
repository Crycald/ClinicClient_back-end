package com.client.clientapi.domain.logs;

import com.client.clientapi.domain.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "CUSTOMER_AUD")
public class CustomerLogs {
    @Id
    @GeneratedValue
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

    @Column(name = "LASTNAME_OLD")
    private String lastnameOld;

    @Column(name = "PWD_OLD")
    private String passwordOld;

    @Column(name = "EMAIL_OLD")
    private String emailOld;

    @Column(name = "PHONE_NUMBER_OLD")
    private String phoneNumberOld;

    @Column(name = "LASTNAME_NEW")
    private String lastnameNew;

    @Column(name = "PWD_NEW")
    private String passwordNew;

    @Column(name = "EMAIL_NEW")
    private String emailNew;

    @Column(name = "PHONE_NUMBER_NEW")
    private String phoneNumberNew;
}
