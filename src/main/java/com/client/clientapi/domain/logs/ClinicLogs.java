package com.client.clientapi.domain.logs;

import com.client.clientapi.domain.Clinic;
import com.client.clientapi.domain.enums.TypeOfAnimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "CLINIC_AUD")
public class ClinicLogs {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "CLINIC_ID")
    private Clinic clinicId;

    @Column(name = "IP_ADDRESS")
    private String ipAddress;

    @Column(name = "OPERATION")
    private String operation;

    @Column(name = "DATE")
    private final LocalDateTime date = LocalDateTime.now();

    @Column(name = "ADDRESS_OLD")
    private String addressOld;

    @Column(name = "NIP_OLD")
    private Long nipOld;

    @Column(name = "PHONE_NUMBER_OLD")
    private String phoneNumberOld;

    @Column(name = "MAIL_OLD")
    private String mailOld;

    @Column(name = "PWD_OLD")
    private String passwordOld;

    @Column(name = "ADDRESS_NEW")
    private String addressNew;

    @Column(name = "NIP_NEW")
    private Long nipNew;

    @Column(name = "PHONE_NUMBER_NEW")
    private String phoneNumberNew;

    @Column(name = "MAIL_NEW")
    private String mailNew;

    @Column(name = "PWD_NEW")
    private String passwordNew;
}