package com.client.clientapi.domain.logs;

import com.client.clientapi.domain.Clinic;
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
}