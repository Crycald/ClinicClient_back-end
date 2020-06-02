package com.client.clientapi.mapper;

import com.client.clientapi.domain.ClinicOperations;
import com.client.clientapi.domain.ClinicOperationsDto;
import com.client.clientapi.domain.enums.Operation;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ClinicOperationsMapperTestSuite {
    private ClinicOperationsMapper mapper = new ClinicOperationsMapper();

    @Test
    public void testMap() {
        ClinicOperationsDto clinicOperationsDto = new ClinicOperationsDto(1L, 1L, Operation.AMPUTACJA, new BigDecimal(50));
        ClinicOperations clinicOperations = mapper.map(clinicOperationsDto);

        Assert.assertEquals(clinicOperationsDto.getId(), clinicOperations.getId());
        Assert.assertEquals(clinicOperationsDto.getClinic_id(), clinicOperations.getClinic_id());
        Assert.assertEquals(clinicOperationsDto.getOperations(), clinicOperations.getOperations());
        Assert.assertEquals(clinicOperationsDto.getCost(), clinicOperations.getCost());
    }

    @Test
    public void testMapToDto() {
        ClinicOperations clinicOperations = new ClinicOperations(1L, 1L, Operation.AMPUTACJA, new BigDecimal(50));
        ClinicOperationsDto clinicOperationsDto = mapper.mapToDto(clinicOperations);

        Assert.assertEquals(clinicOperationsDto.getId(), clinicOperations.getId());
        Assert.assertEquals(clinicOperationsDto.getClinic_id(), clinicOperations.getClinic_id());
        Assert.assertEquals(clinicOperationsDto.getOperations(), clinicOperations.getOperations());
        Assert.assertEquals(clinicOperationsDto.getCost(), clinicOperations.getCost());
    }

    @Test
    public void testList() {
        ClinicOperations clinicOperations1 = new ClinicOperations(1L, 1L, Operation.AMPUTACJA, new BigDecimal(50));
        ClinicOperations clinicOperations2 = new ClinicOperations(1L, 1L, Operation.AMPUTACJA, new BigDecimal(50));
        ClinicOperations clinicOperations3 = new ClinicOperations(1L, 1L, Operation.AMPUTACJA, new BigDecimal(50));
        ClinicOperations clinicOperations4 = new ClinicOperations(1L, 1L, Operation.AMPUTACJA, new BigDecimal(50));
        ClinicOperations clinicOperations5 = new ClinicOperations(1L, 1L, Operation.AMPUTACJA, new BigDecimal(50));

        List<ClinicOperations> clinicOperations = new ArrayList<>();
        clinicOperations.add(clinicOperations1);
        clinicOperations.add(clinicOperations2);
        clinicOperations.add(clinicOperations3);
        clinicOperations.add(clinicOperations4);
        clinicOperations.add(clinicOperations5);

        List<ClinicOperationsDto> clinicOperationsDtoList = mapper.list(clinicOperations);

        Assert.assertEquals(5, clinicOperationsDtoList.size());
    }
}
