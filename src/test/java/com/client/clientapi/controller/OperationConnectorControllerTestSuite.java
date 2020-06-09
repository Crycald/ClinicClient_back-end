package com.client.clientapi.controller;

import com.client.clientapi.domain.OperationConnectorDto;
import com.client.clientapi.service.OperationConnectorService;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(OperationConnectorController.class)
public class OperationConnectorControllerTestSuite {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    private OperationConnectorService service;

    @Test
    public void shouldFetchEmptyOperationConnectorList() throws Exception {
        List<OperationConnectorDto> operationConnectorDtoList = new ArrayList<>();

        when(service.getOperationConnectors()).thenReturn(operationConnectorDtoList);

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/operationLists").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(0)));
    }

    @Test
    public void shouldFetchOperationConnectorList() throws Exception {
        List<OperationConnectorDto> operationConnectorDtoList = new ArrayList<>();
        operationConnectorDtoList.add(new OperationConnectorDto(1L, 1L, 1L, 1L));

        when(service.getOperationConnectors()).thenReturn(operationConnectorDtoList);

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/operationLists").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))

                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].clinicId", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].customerId", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].operationActId", Matchers.is(1)));
    }

    @Test
    public void shouldFetchOperationConnectorListById() throws Exception {
        OperationConnectorDto operationDto = new OperationConnectorDto(1L, 1L, 1L, 1L);

        when(service.getOperationConnectorById(1L)).thenReturn(operationDto);

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/operationLists/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))

                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.clinicId", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.customerId", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operationActId", Matchers.is(1)));
    }

    @Test
    public void shouldDeleteOperationConnectorById() throws Exception {
        OperationConnectorDto operationDto = new OperationConnectorDto(1L, 1L, 1L, 1L);

        when(service.getOperationConnectorById(1L)).thenReturn(operationDto);

        mockMvc.perform(MockMvcRequestBuilders.delete("/v1/operationLists/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
