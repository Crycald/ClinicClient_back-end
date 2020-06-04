package com.client.clientapi.mapper;

import com.client.clientapi.domain.OperationConnector;
import com.client.clientapi.domain.OperationConnectorDto;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class OperationConnectorMapperTestSuite {
    private OperationConnectorMapper mapper = new OperationConnectorMapper();

    @Test
    public void testDtoToMap() {
        OperationConnectorDto operationConnectorDto = new OperationConnectorDto(1L, 1L, 1L, 1L);
        OperationConnector operationConnector = mapper.map(operationConnectorDto);

        Assert.assertEquals(operationConnector.getId(), operationConnectorDto.getId());
        Assert.assertEquals(operationConnector.getClinicId(), operationConnectorDto.getClinicId());
        Assert.assertEquals(operationConnector.getCustomerId(), operationConnectorDto.getCustomerId());
        Assert.assertEquals(operationConnector.getOperationActId(), operationConnectorDto.getOperationActId());
    }

    @Test
    public void testMapToDto() {
        OperationConnector operationConnector = new OperationConnector(1L, 1L, 1L, 1L, LocalDate.of(2020,10,10));
        OperationConnectorDto operationConnectorDto = mapper.mapToDto(operationConnector);

        Assert.assertEquals(operationConnectorDto.getId(), operationConnector.getId());
        Assert.assertEquals(operationConnectorDto.getClinicId(), operationConnector.getClinicId());
        Assert.assertEquals(operationConnectorDto.getCustomerId(), operationConnector.getCustomerId());
        Assert.assertEquals(operationConnectorDto.getOperationActId(), operationConnector.getOperationActId());
    }

    @Test
    public void testToList() {
        OperationConnector operationConnector1 = new OperationConnector(1L, 1L, 1L, 1L, LocalDate.of(2020,10,10));
        OperationConnector operationConnector2 = new OperationConnector(2L, 2L, 2L, 2L, LocalDate.of(2020,10,10));
        OperationConnector operationConnector3 = new OperationConnector(3L, 3L, 3L, 3L, LocalDate.of(2020,10,10));
        OperationConnector operationConnector4 = new OperationConnector(4L, 4L, 4L, 4L, LocalDate.of(2020,10,10));

        List<OperationConnector> connectorList = new ArrayList<>();
        connectorList.add(operationConnector1);
        connectorList.add(operationConnector2);
        connectorList.add(operationConnector3);
        connectorList.add(operationConnector4);

        List<OperationConnectorDto> operationConnectorDtoList = mapper.list(connectorList);

        Assert.assertEquals(4, operationConnectorDtoList.size());
    }
}
