package com.client.clientapi.mapper;

import com.client.clientapi.domain.Clinic;
import com.client.clientapi.domain.ClinicDto;
import com.client.clientapi.domain.enums.TypeOfAnimal;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ClinicMapperTestSuite {
    private ClinicMapper mapper = new ClinicMapper();

    @Test
    public void testMap() {
        ClinicDto clinicDto = new ClinicDto(1L, "comp_name", TypeOfAnimal.FRETKA, "Address", 132352553L, "123-123-123", "mail@mail.com", "pwd123");
        Clinic clinic = mapper.map(clinicDto);

        Assert.assertEquals(clinicDto.getId(), clinic.getId());
        Assert.assertEquals(clinicDto.getName(), clinic.getName());
        Assert.assertEquals(clinicDto.getTypeOfAnimal(), clinic.getTypeOfAnimal());
        Assert.assertEquals(clinicDto.getAddress(), clinic.getAddress());
        Assert.assertEquals(clinicDto.getNip(), clinic.getNip());
        Assert.assertEquals(clinicDto.getPhoneNumber(), clinic.getPhoneNumber());
        Assert.assertEquals(clinicDto.getMail(), clinic.getMail());
        Assert.assertEquals(clinicDto.getPassword(), clinic.getPassword());
    }

    @Test
    public void testMapToDto() {
        Clinic clinic = new Clinic(1L, "comp_name", TypeOfAnimal.FRETKA, "Address", 132352553L, "123-123-123", "mail@mail.com", "pwd123");
        ClinicDto clinicDto = mapper.mapToDto(clinic);

        Assert.assertEquals(clinic.getId(), clinicDto.getId());
        Assert.assertEquals(clinic.getName(), clinicDto.getName());
        Assert.assertEquals(clinic.getAddress(), clinicDto.getAddress());
        Assert.assertEquals(clinic.getMail(), clinicDto.getMail());
        Assert.assertEquals(clinic.getTypeOfAnimal(), clinicDto.getTypeOfAnimal());
        Assert.assertEquals(clinic.getNip(), clinicDto.getNip());
        Assert.assertEquals(clinic.getPassword(), clinicDto.getPassword());
    }

    @Test
    public void testList() {
        Clinic clinic1 = new Clinic(1L, "comp_name", TypeOfAnimal.FRETKA, "Address", 132352553L, "123-123-123", "mail@mail.com", "pwd123");
        Clinic clinic2 = new Clinic(1L, "comp_name", TypeOfAnimal.FRETKA, "Address", 132352553L, "123-123-123", "mail@mail.com", "pwd123");
        Clinic clinic3 = new Clinic(1L, "comp_name", TypeOfAnimal.FRETKA, "Address", 132352553L, "123-123-123", "mail@mail.com", "pwd123");
        Clinic clinic4 = new Clinic(1L, "comp_name", TypeOfAnimal.FRETKA, "Address", 132352553L, "123-123-123", "mail@mail.com", "pwd123");

        List<Clinic> clinics = new ArrayList<>();
        clinics.add(clinic1);
        clinics.add(clinic2);
        clinics.add(clinic3);
        clinics.add(clinic4);

        List<ClinicDto> clinicDtoList = mapper.list(clinics);

        Assert.assertNotNull(clinicDtoList);
    }
}
