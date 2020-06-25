package com.client.clientapi.service;

import com.client.clientapi.domain.ClinicDto;
import com.client.clientapi.domain.OperationDto;
import com.client.clientapi.domain.enums.TypeOfAnimal;
import com.client.clientapi.domain.enums.TypeOfOperation;
import com.client.clientapi.exception.operation.OperationNotFoundException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OperationServiceTestSuite {
    @Autowired
    private OperationService service;

    @Autowired
    private ClinicService clinicService;

    @Test
    public void createOperation() {
        ClinicDto clinic1 = new ClinicDto();
        clinic1.setName("comp_name");
        clinic1.setTypeOfAnimal(TypeOfAnimal.FRETKA);
        clinic1.setAddress("address");
        clinic1.setNip(12312312312L);
        clinic1.setPhoneNumber("123-123-123");
        clinic1.setMail("mail@mail.com");
        clinic1.setLogin("login");
        clinic1.setPassword("pwd123");

        ClinicDto test = clinicService.createClinic(clinic1);
        Long clinicId = test.getId();

        OperationDto operation = new OperationDto();
        operation.setClinicId(clinicId);
        operation.setOperations(TypeOfOperation.AMPUTACJA);
        operation.setCost(new BigDecimal(3000));

        OperationDto test2 = service.createOperation(operation);
        Long operationId = test2.getId();

        Assert.assertNotNull(service.getOperationById(operationId));

        service.deleteOperation(operationId);
        clinicService.deleteClinic(clinicId);
    }

    @Test
    public void updateOperation() {
        ClinicDto clinic1 = new ClinicDto();
        clinic1.setName("comp_name");
        clinic1.setTypeOfAnimal(TypeOfAnimal.FRETKA);
        clinic1.setAddress("address");
        clinic1.setNip(12312312312L);
        clinic1.setPhoneNumber("123-123-123");
        clinic1.setMail("mail@mail.com");
        clinic1.setLogin("login");
        clinic1.setPassword("pwd123");

        ClinicDto test = clinicService.createClinic(clinic1);
        Long clinicId = test.getId();

        OperationDto operation = new OperationDto();
        operation.setClinicId(clinicId);
        operation.setOperations(TypeOfOperation.AMPUTACJA);
        operation.setCost(new BigDecimal(3000));

        OperationDto test2 = service.createOperation(operation);
        Long operationId = test2.getId();

        OperationDto operation2 = new OperationDto();
        operation2.setId(operationId);
        operation2.setClinicId(clinicId);
        operation2.setOperations(TypeOfOperation.AMPUTACJA);
        operation2.setCost(new BigDecimal(34));

        service.updateOperation(operation2);

        Assert.assertNotEquals(operation.getCost(), operation2.getCost());

        service.deleteOperation(operationId);
        clinicService.deleteClinic(clinicId);
    }

    @Test(expected = OperationNotFoundException.class)
    public void deleteOperationWhenNotExist() {
        Long id = 12312312451253253L;
        service.deleteOperation(id);
    }

    @Test
    public void getOperationsByClinicId() {
        ClinicDto clinic1 = new ClinicDto();
        clinic1.setName("comp_name");
        clinic1.setTypeOfAnimal(TypeOfAnimal.FRETKA);
        clinic1.setAddress("address");
        clinic1.setNip(12312312312L);
        clinic1.setPhoneNumber("123-123-123");
        clinic1.setMail("mail@mail.com");
        clinic1.setLogin("login");
        clinic1.setPassword("pwd123");

        ClinicDto test = clinicService.createClinic(clinic1);
        Long clinicId = test.getId();

        OperationDto operation = new OperationDto();
        operation.setClinicId(clinicId);
        operation.setOperations(TypeOfOperation.AMPUTACJA);
        operation.setCost(new BigDecimal(3000));

        OperationDto test2 = service.createOperation(operation);
        Long operationId = test2.getId();

        List<OperationDto> list = service.getOperationsByClinicId(clinicId);

        Assert.assertNotNull(list);

        service.deleteOperation(operationId);
        clinicService.deleteClinic(clinicId);
    }
}
