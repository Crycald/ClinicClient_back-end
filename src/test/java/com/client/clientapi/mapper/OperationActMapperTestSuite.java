package com.client.clientapi.mapper;

import com.client.clientapi.domain.Clinic;
import com.client.clientapi.domain.OperationAct;
import com.client.clientapi.domain.OperationActDto;
import com.client.clientapi.domain.enums.Operation;
import com.client.clientapi.domain.enums.TypeOfAnimal;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OperationActMapperTestSuite {
    private ClinicOperationsMapper mapper = new ClinicOperationsMapper();

    @Test
    public void testMap() {
        OperationActDto operationActDto = new OperationActDto(1L, 1L, com.client.clientapi.domain.enums.Operation.AMPUTACJA, new BigDecimal(50));
        Clinic clinic1 = new Clinic();
        clinic1.setId(1L);
        clinic1.setName("comp_name");
        clinic1.setTypeOfAnimal(TypeOfAnimal.FRETKA);
        clinic1.setAddress("address");
        clinic1.setNip(12312312312L);
        clinic1.setPhoneNumber("123-123-123");
        clinic1.setMail("mail@mail.com");
        clinic1.setPassword("pwd123");

        OperationAct operationAct = mapper.map(operationActDto, clinic1);

        Assert.assertEquals(operationActDto.getId(), operationAct.getId());
        Assert.assertEquals(operationActDto.getClinic_id(), operationAct.getClinic_id().getId());
        Assert.assertEquals(operationActDto.getOperations(), operationAct.getOperations());
        Assert.assertEquals(operationActDto.getCost(), operationAct.getCost());
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

        OperationAct operationAct = new OperationAct();
        operationAct.setId(1L);
        operationAct.setClinic_id(clinic1);
        operationAct.setOperations(Operation.AMPUTACJA);
        operationAct.setCost(new BigDecimal(10000.00));
        OperationActDto operationActDto = mapper.mapToDto(operationAct);

        Assert.assertEquals(operationActDto.getId(), operationAct.getId());
        Assert.assertEquals(operationActDto.getClinic_id(), operationAct.getClinic_id().getId());
        Assert.assertEquals(operationActDto.getOperations(), operationAct.getOperations());
        Assert.assertEquals(operationActDto.getCost(), operationAct.getCost());
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

        OperationAct operationAct1 = new OperationAct();

        operationAct1.setId(1L);
        operationAct1.setClinic_id(clinic1);
        operationAct1.setOperations(Operation.AMPUTACJA);
        operationAct1.setCost(new BigDecimal(10000.00));
        OperationActDto operationActDto = mapper.mapToDto(operationAct1);

        List<OperationAct> clinicOperationActs = new ArrayList<>();
        clinicOperationActs.add(operationAct1);

        List<OperationActDto> operationActDtoList = mapper.list(clinicOperationActs);

        Assert.assertEquals(1, operationActDtoList.size());
    }
}
