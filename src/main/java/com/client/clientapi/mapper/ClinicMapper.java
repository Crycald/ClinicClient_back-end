package com.client.clientapi.mapper;

import com.client.clientapi.domain.Clinic;
import com.client.clientapi.domain.ClinicDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClinicMapper {
    public Clinic map(final ClinicDto clinicDto) {
        return Clinic.builder()
                .id(clinicDto.getId())
                .name(clinicDto.getName())
                .address(clinicDto.getAddress())
                .nip(clinicDto.getNip())
                .password(clinicDto.getPassword())
                .phoneNumber(clinicDto.getPhoneNumber())
                .mail(clinicDto.getMail())
                .build();
    }

    public ClinicDto mapToDto(final Clinic clinic) {
        return ClinicDto.builder()
                .id(clinic.getId())
                .name(clinic.getName())
                .address(clinic.getAddress())
                .nip(clinic.getNip())
                .password(clinic.getPassword())
                .phoneNumber(clinic.getPhoneNumber())
                .mail(clinic.getMail())
                .build();
    }

    public List<ClinicDto> list(final List<Clinic> clinicList) {
        return clinicList.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }
}
