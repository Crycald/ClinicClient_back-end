package com.client.clientapi.domain;

import com.client.clientapi.domain.enums.TypeOfAnimal;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Data
@Entity
@Table(name = "CLINICS")
public class Clinic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
}
