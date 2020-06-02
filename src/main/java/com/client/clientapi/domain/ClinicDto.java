package com.client.clientapi.domain;

import com.client.clientapi.domain.enums.TypeOfAnimal;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ClinicDto {
    private Long id;
    private String name;
    private TypeOfAnimal typeOfAnimal;
    private String address;
    private Long nip;
    private String phoneNumber;
    private String mail;
    private String password;
}
