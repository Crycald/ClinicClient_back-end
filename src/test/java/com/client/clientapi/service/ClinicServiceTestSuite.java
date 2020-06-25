package com.client.clientapi.service;

import com.client.clientapi.domain.ClinicDto;
import com.client.clientapi.domain.enums.TypeOfAnimal;
import com.client.clientapi.exception.clinic.ClinicNotFoundException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClinicServiceTestSuite {
    @Autowired
    private ClinicService service;

    @Test
    public void createClinicTest() {
        ClinicDto clinic1 = new ClinicDto();
        clinic1.setName("comp_name");
        clinic1.setTypeOfAnimal(TypeOfAnimal.FRETKA);
        clinic1.setAddress("address");
        clinic1.setNip(12312312312L);
        clinic1.setPhoneNumber("123-123-123");
        clinic1.setMail("mail@mail.com");
        clinic1.setLogin("login");
        clinic1.setPassword("pwd123");

       ClinicDto test = service.createClinic(clinic1);
       Long id = test.getId();

       Assert.assertNotNull(service.getClinicById(id));

       service.deleteClinic(id);
    }

    @Test
    public void updateClinicTest() {
        ClinicDto clinic1 = new ClinicDto();
        clinic1.setName("comp_name");
        clinic1.setTypeOfAnimal(TypeOfAnimal.FRETKA);
        clinic1.setAddress("address");
        clinic1.setNip(12312312312L);
        clinic1.setPhoneNumber("123-123-123");
        clinic1.setMail("mail@mail.com");
        clinic1.setLogin("login");
        clinic1.setPassword("pwd123");

        ClinicDto clinic2 = new ClinicDto();
        clinic2.setName("testName");
        clinic2.setTypeOfAnimal(TypeOfAnimal.FRETKA);
        clinic2.setAddress("address");
        clinic2.setNip(12312312312L);
        clinic2.setPhoneNumber("123-123-123");
        clinic2.setMail("mail@mail.com");
        clinic2.setLogin("login");
        clinic2.setPassword("pwd123");

        ClinicDto test = service.createClinic(clinic1);
        Long id = test.getId();

        clinic2.setId(id);

        service.updateClinic(clinic2);

        Assert.assertNotEquals(clinic1.getName(), clinic2.getName());
        service.deleteClinic(id);
    }

    @Test
    public void validateClinicAndReturnIdTest() {
        ClinicDto clinic1 = new ClinicDto();
        clinic1.setName("comp_name");
        clinic1.setTypeOfAnimal(TypeOfAnimal.FRETKA);
        clinic1.setAddress("address");
        clinic1.setNip(12312312312L);
        clinic1.setPhoneNumber("123-123-123");
        clinic1.setMail("mail@mail.com");
        clinic1.setLogin("login");
        clinic1.setPassword("pwd123");

        ClinicDto test = service.createClinic(clinic1);
        Long id = test.getId();

        Long returnedId = service.validateClinicAndReturnId(clinic1.getLogin(), clinic1.getPassword());

        Assert.assertEquals(id, returnedId);

        service.deleteClinic(id);
    }

    @Test
    public void validateClinicAndReturnNullTest() {
        ClinicDto clinic1 = new ClinicDto();
        clinic1.setName("comp_name");
        clinic1.setTypeOfAnimal(TypeOfAnimal.FRETKA);
        clinic1.setAddress("address");
        clinic1.setNip(12312312312L);
        clinic1.setPhoneNumber("123-123-123");
        clinic1.setMail("mail@mail.com");
        clinic1.setLogin("login");
        clinic1.setPassword("pwd123");

        String login = "dasdsaGGFDG@$2f2F@#FF#1f";

        ClinicDto test = service.createClinic(clinic1);
        Long id = test.getId();

        Long returnedId = service.validateClinicAndReturnId(login, clinic1.getPassword());

        Assert.assertNotEquals(id, returnedId);

        service.deleteClinic(id);
    }

    @Test
    public void validateClinicLoginWhenExistTest() {
        ClinicDto clinic1 = new ClinicDto();
        clinic1.setName("comp_name");
        clinic1.setTypeOfAnimal(TypeOfAnimal.FRETKA);
        clinic1.setAddress("address");
        clinic1.setNip(12312312312L);
        clinic1.setPhoneNumber("123-123-123");
        clinic1.setMail("mail@mail.com");
        clinic1.setLogin("login");
        clinic1.setPassword("pwd123");

        ClinicDto test = service.createClinic(clinic1);
        Long id = test.getId();

        Boolean isExist = service.validateClinicLogin(clinic1.getLogin());

        Assert.assertTrue(isExist);

        service.deleteClinic(id);
    }

    @Test
    public void validateClinicLoginWhenNotExistTest() {
        String login = "DSADgdXCVXVX#%gdfsg23521fds";
        Boolean isExist = service.validateClinicLogin(login);

        Assert.assertFalse(isExist);
    }

    @Test
    public void getClinicsByTypeOfAnimalTest() {
        TypeOfAnimal fretkooo = TypeOfAnimal.FRETKA;

        ClinicDto clinic1 = new ClinicDto();
        clinic1.setName("comp_name");
        clinic1.setTypeOfAnimal(TypeOfAnimal.FRETKA);
        clinic1.setAddress("address");
        clinic1.setNip(12312312312L);
        clinic1.setPhoneNumber("123-123-123");
        clinic1.setMail("mail@mail.com");
        clinic1.setLogin("login");
        clinic1.setPassword("pwd123");

        ClinicDto clinic2 = new ClinicDto();
        clinic2.setName("comp_name");
        clinic2.setTypeOfAnimal(TypeOfAnimal.FRETKA);
        clinic2.setAddress("address");
        clinic2.setNip(12312312312L);
        clinic2.setPhoneNumber("123-123-123");
        clinic2.setMail("mail@mail.com");
        clinic2.setLogin("login");
        clinic2.setPassword("pwd123");

        ClinicDto test = service.createClinic(clinic1);
        ClinicDto test2 = service.createClinic(clinic2);
        Long id = test.getId();
        Long id2 = test2.getId();

        List<ClinicDto> list = service.getClinicsByTypeOfAnimal(fretkooo);
        Assert.assertNotNull(list);

        service.deleteClinic(id);
        service.deleteClinic(id2);
    }

    @Test(expected = ClinicNotFoundException.class)
    public void deleteClinicThrowNotFoundClinicExceptionTest() {
        Long id = 40433434L;
        service.deleteClinic(id);
    }

    @Test
    public void getClinicsTest() {
        ClinicDto clinic1 = new ClinicDto();
        clinic1.setName("comp_name");
        clinic1.setTypeOfAnimal(TypeOfAnimal.FRETKA);
        clinic1.setAddress("address");
        clinic1.setNip(12312312312L);
        clinic1.setPhoneNumber("123-123-123");
        clinic1.setMail("mail@mail.com");
        clinic1.setLogin("login");
        clinic1.setPassword("pwd123");

        ClinicDto clinic2 = new ClinicDto();
        clinic2.setName("comp_name");
        clinic2.setTypeOfAnimal(TypeOfAnimal.FRETKA);
        clinic2.setAddress("address");
        clinic2.setNip(12312312312L);
        clinic2.setPhoneNumber("123-123-123");
        clinic2.setMail("mail@mail.com");
        clinic2.setLogin("login");
        clinic2.setPassword("pwd123");

        ClinicDto test = service.createClinic(clinic1);
        ClinicDto test2 = service.createClinic(clinic2);
        Long id = test.getId();
        Long id2 = test2.getId();

        List<ClinicDto> list = service.getClinics();
        Assert.assertNotNull(list);

        service.deleteClinic(id);
        service.deleteClinic(id2);
    }
}
