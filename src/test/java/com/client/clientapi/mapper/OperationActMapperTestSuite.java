package com.client.clientapi.mapper;

import com.client.clientapi.domain.OperationAct;
import com.client.clientapi.domain.OperationActDto;
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
        OperationAct operationAct = mapper.map(operationActDto);

        Assert.assertEquals(operationActDto.getId(), operationAct.getId());
        Assert.assertEquals(operationActDto.getClinic_id(), operationAct.getClinic_id());
        Assert.assertEquals(operationActDto.getOperations(), operationAct.getOperations());
        Assert.assertEquals(operationActDto.getCost(), operationAct.getCost());
    }

    @Test
    public void testMapToDto() {
        OperationAct operationAct = new OperationAct(1L, 1L, com.client.clientapi.domain.enums.Operation.AMPUTACJA, new BigDecimal(50));
        OperationActDto operationActDto = mapper.mapToDto(operationAct);

        Assert.assertEquals(operationActDto.getId(), operationAct.getId());
        Assert.assertEquals(operationActDto.getClinic_id(), operationAct.getClinic_id());
        Assert.assertEquals(operationActDto.getOperations(), operationAct.getOperations());
        Assert.assertEquals(operationActDto.getCost(), operationAct.getCost());
    }

    @Test
    public void testList() {
        OperationAct operationAct1 = new OperationAct(1L, 1L, com.client.clientapi.domain.enums.Operation.AMPUTACJA, new BigDecimal(50));
        OperationAct operationAct2 = new OperationAct(1L, 1L, com.client.clientapi.domain.enums.Operation.AMPUTACJA, new BigDecimal(50));
        OperationAct operationAct3 = new OperationAct(1L, 1L, com.client.clientapi.domain.enums.Operation.AMPUTACJA, new BigDecimal(50));
        OperationAct operationAct4 = new OperationAct(1L, 1L, com.client.clientapi.domain.enums.Operation.AMPUTACJA, new BigDecimal(50));
        OperationAct operationAct5 = new OperationAct(1L, 1L, com.client.clientapi.domain.enums.Operation.AMPUTACJA, new BigDecimal(50));

        List<OperationAct> clinicOperationActs = new ArrayList<>();
        clinicOperationActs.add(operationAct1);
        clinicOperationActs.add(operationAct2);
        clinicOperationActs.add(operationAct3);
        clinicOperationActs.add(operationAct4);
        clinicOperationActs.add(operationAct5);

        List<OperationActDto> operationActDtoList = mapper.list(clinicOperationActs);

        Assert.assertEquals(5, operationActDtoList.size());
    }
}
