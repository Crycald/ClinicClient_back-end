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
        Clinic clinic1 = new Clinic();
        clinic1.setId(1L);
        clinic1.setName("comp_name");
        clinic1.setTypeOfAnimal(TypeOfAnimal.FRETKA);
        clinic1.setAddress("address");
        clinic1.setNip(12312312312L);
        clinic1.setPhoneNumber("123-123-123");
        clinic1.setMail("mail@mail.com");
        clinic1.setPassword("pwd123");

        ClinicDto clinicDto = mapper.mapToDto(clinic1);

        Assert.assertEquals(clinic1.getId(), clinicDto.getId());
        Assert.assertEquals(clinic1.getName(), clinicDto.getName());
        Assert.assertEquals(clinic1.getAddress(), clinicDto.getAddress());
        Assert.assertEquals(clinic1.getMail(), clinicDto.getMail());
        Assert.assertEquals(clinic1.getTypeOfAnimal(), clinicDto.getTypeOfAnimal());
        Assert.assertEquals(clinic1.getNip(), clinicDto.getNip());
        Assert.assertEquals(clinic1.getPassword(), clinicDto.getPassword());
    }

    @Test
    public void testList() {
        Clinic clinic1 = new Clinic();
        clinic1.setId(1L);
        clinic1.setName("comp_name");
        clinic1.setTypeOfAnimal(TypeOfAnimal.FRETKA);
        clinic1.setAddress("address");
        clinic1.setNip(12312312312L);
        clinic1.setPhoneNumber("123-123-123");
        clinic1.setMail("mail@mail.com");
        clinic1.setPassword("pwd123");

        List<Clinic> clinics = new ArrayList<>();
        clinics.add(clinic1);

        List<ClinicDto> clinicDtoList = mapper.list(clinics);

        Assert.assertNotNull(clinicDtoList);
    }
}
