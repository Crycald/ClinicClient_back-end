package com.client.clientapi.mapper;

import com.client.clientapi.domain.Clinic;
import com.client.clientapi.domain.Operation;
import com.client.clientapi.domain.OperationDto;
import com.client.clientapi.domain.enums.TypeOfOperation;
import com.client.clientapi.domain.enums.TypeOfAnimal;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TypeOfOperationMapperTestSuite {
    private OperationMapper mapper = new OperationMapper();

    @Test
    public void testMap() {
        OperationDto operationDto = new OperationDto(1L, 1L, TypeOfOperation.AMPUTACJA, new BigDecimal(50));
        Clinic clinic1 = new Clinic();
        clinic1.setId(1L);
        clinic1.setName("comp_name");
        clinic1.setTypeOfAnimal(TypeOfAnimal.FRETKA);
        clinic1.setAddress("address");
        clinic1.setNip(12312312312L);
        clinic1.setPhoneNumber("123-123-123");
        clinic1.setMail("mail@mail.com");
        clinic1.setPassword("pwd123");

        Operation operation = mapper.map(operationDto, clinic1);

        Assert.assertEquals(operationDto.getId(), operation.getId());
        Assert.assertEquals(operationDto.getClinicId(), operation.getClinicId().getId());
        Assert.assertEquals(operationDto.getOperations(), operation.getOperations());
        Assert.assertEquals(operationDto.getCost(), operation.getCost());
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

        Operation operation = new Operation();
        operation.setId(1L);
        operation.setClinicId(clinic1);
        operation.setOperations(TypeOfOperation.AMPUTACJA);
        operation.setCost(new BigDecimal(10000.00));
        OperationDto operationDto = mapper.mapToDto(operation);

        Assert.assertEquals(operationDto.getId(), operation.getId());
        Assert.assertEquals(operationDto.getClinicId(), operation.getClinicId().getId());
        Assert.assertEquals(operationDto.getOperations(), operation.getOperations());
        Assert.assertEquals(operationDto.getCost(), operation.getCost());
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

        Operation operation1 = new Operation();

        operation1.setId(1L);
        operation1.setClinicId(clinic1);
        operation1.setOperations(TypeOfOperation.AMPUTACJA);
        operation1.setCost(new BigDecimal(10000.00));
        OperationDto operationDto = mapper.mapToDto(operation1);

        List<Operation> clinicOperations = new ArrayList<>();
        clinicOperations.add(operation1);

        List<OperationDto> operationDtoList = mapper.list(clinicOperations);

        Assert.assertEquals(1, operationDtoList.size());
    }
}
