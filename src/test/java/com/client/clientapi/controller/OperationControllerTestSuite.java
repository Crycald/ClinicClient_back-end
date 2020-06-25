package com.client.clientapi.controller;

import com.client.clientapi.domain.OperationDto;
import com.client.clientapi.domain.enums.TypeOfOperation;
import com.client.clientapi.service.OperationService;
import com.google.gson.Gson;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(OperationController.class)
public class OperationControllerTestSuite {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OperationService service;

    @Test
    public void shouldFetchEmptyOperationList() throws Exception {
        List<OperationDto> operationDtoList = new ArrayList<>();

        when(service.getOperations()).thenReturn(operationDtoList);

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/operations").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(0)));
    }

    @Test
    public void shouldFetchOperationList() throws Exception {
        List<OperationDto> operationDtoList = new ArrayList<>();
        operationDtoList.add(new OperationDto(1L, 1L, TypeOfOperation.AMPUTACJA, new BigDecimal(1000.00)));

        when(service.getOperations()).thenReturn(operationDtoList);

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/operations").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())

                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].clinicId", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].operations", Matchers.is(TypeOfOperation.AMPUTACJA.toString())))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].cost", Matchers.is(1000)));

    }

    @Test
    public void shouldFetchOperationListById() throws Exception {
        OperationDto operationDto = new OperationDto(1L, 1L, TypeOfOperation.AMPUTACJA, new BigDecimal(1000.00));

        when(service.getOperationById(1L)).thenReturn(operationDto);

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/operations/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))

                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.clinicId", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operations", Matchers.is(TypeOfOperation.AMPUTACJA.toString())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.cost", Matchers.is(1000)));
    }

    @Test
    public void shouldDeleteOperationById() throws Exception {
        OperationDto operationDto = new OperationDto(1L, 1L, TypeOfOperation.AMPUTACJA, new BigDecimal(1000.00));

        when(service.getOperationById(1L)).thenReturn(operationDto);

        mockMvc.perform(MockMvcRequestBuilders.delete("/v1/operations/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void shouldUpdateOperation() throws Exception {
        OperationDto operationDto = new OperationDto(1L, 1L, TypeOfOperation.AMPUTACJA, new BigDecimal(1000.00));

        when(service.updateOperation(ArgumentMatchers.any())).thenReturn(operationDto);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(operationDto);

        mockMvc.perform(MockMvcRequestBuilders.put("/v1/operations").contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))

                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.clinicId", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operations", Matchers.is(TypeOfOperation.AMPUTACJA.toString())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.cost", Matchers.is(1000)));
    }
}
