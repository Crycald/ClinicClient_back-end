package com.client.clientapi.domain;

import com.client.clientapi.domain.enums.Operations;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Data
@Entity
@Table(name = "CLIENT_REGISTRATIONS")
public class ClientRegistrations {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(
            name = "CLIENT_ID", nullable = false
    )
    private Customer clientId;

    @ManyToOne
    @JoinColumn(
            name = "CLINIC_ID", nullable = false
    )
    private Clinic clinicId;

    @ManyToOne
    @JoinColumn(
            name = "CLINIC_NAME", nullable = false
    )
    private Clinic clinicName;

    @Enumerated(EnumType.STRING)
    @Column(name = "CLINIC_OPERATION", nullable = false)
    private Operations clinicOperation;

    @Column(name = "CLINIC_OPERATION_COST", nullable = false)
    private BigDecimal clinicOperationCost;

    @Column(name = "DATE", nullable = false)
    private Date date;
}
