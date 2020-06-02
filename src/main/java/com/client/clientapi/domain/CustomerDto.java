package com.client.clientapi.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CustomerDto {
    private Long id;
    private String firstname;
    private String lastname;
    private String password;
    private String email;
    private String phoneNumber;

}
