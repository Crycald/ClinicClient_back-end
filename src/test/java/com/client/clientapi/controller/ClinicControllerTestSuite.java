package com.client.clientapi.controller;

import com.client.clientapi.client.IpifyClient;
import com.client.clientapi.domain.Clinic;
import com.client.clientapi.domain.ClinicDto;
import com.client.clientapi.domain.enums.TypeOfAnimal;
import com.client.clientapi.service.ClinicService;
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

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(ClinicController.class)
public class ClinicControllerTestSuite {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClinicService service;

    @Test
    public void shouldFetchEmptyClinicList() throws Exception {
        List<ClinicDto> clinicDtoList = new ArrayList<>();

        when(service.getClinics()).thenReturn(clinicDtoList);

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/clinics").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(0)));
    }

    @Test
    public void shouldFetchClinicList() throws Exception {
        List<ClinicDto> clinicDtoList = new ArrayList<>();
        clinicDtoList.add(new ClinicDto(1L, "name", TypeOfAnimal.FRETKA, "address", 12312313L, "123-123-123", "@@@@", "pwd"));

        when(service.getClinics()).thenReturn(clinicDtoList);

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/clinics").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))

                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name", Matchers.is("name")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].typeOfAnimal", Matchers.is(TypeOfAnimal.FRETKA.toString())))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].address", Matchers.is("address")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].nip", Matchers.is(12312313)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].phoneNumber", Matchers.is("123-123-123")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].mail", Matchers.is("@@@@")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].password", Matchers.is("pwd")));
    }

    @Test
    public void shouldFetchClinicById() throws Exception {
        ClinicDto clinicDto = new ClinicDto(1L, "name", TypeOfAnimal.FRETKA, "address", 12312313L, "123-123-123", "@@@@", "pwd");
        Clinic clinic = new Clinic();
        clinic.setId(1L);
        clinic.setName("name");
        clinic.setTypeOfAnimal(TypeOfAnimal.FRETKA);
        clinic.setAddress("address");
        clinic.setNip(12312313L);
        clinic.setPhoneNumber("123-123-123");
        clinic.setMail("@@@@");
        clinic.setPassword("pwd");

        when(service.getClinicById(1L)).thenReturn(clinicDto);

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/clinics/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))

                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", Matchers.is("name")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.typeOfAnimal", Matchers.is(TypeOfAnimal.FRETKA.toString())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.address", Matchers.is("address")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.nip", Matchers.is(12312313)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.phoneNumber", Matchers.is("123-123-123")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.mail", Matchers.is("@@@@")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.password", Matchers.is("pwd")));
    }

    @Test
    public void shouldDeleteClinicById() throws Exception {
        ClinicDto clinicDto = new ClinicDto(1L, "name", TypeOfAnimal.FRETKA, "address", 12312313L, "123-123-123", "@@@@", "pwd");

        when(service.getClinicById(1L)).thenReturn(clinicDto);

        mockMvc.perform(MockMvcRequestBuilders.delete("/v1/clinics/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void shouldUpdateClinic() throws Exception {
        ClinicDto clinicDto = new ClinicDto(1L, "name", TypeOfAnimal.FRETKA, "address", 12312313L, "123-123-123", "@@@@", "pwd");

        when(service.updateClinic(ArgumentMatchers.any())).thenReturn(clinicDto);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(clinicDto);

        mockMvc.perform(MockMvcRequestBuilders.put("/v1/clinics").contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))

                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", Matchers.is("name")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.typeOfAnimal", Matchers.is(TypeOfAnimal.FRETKA.toString())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.address", Matchers.is("address")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.nip", Matchers.is(12312313)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.phoneNumber", Matchers.is("123-123-123")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.mail", Matchers.is("@@@@")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.password", Matchers.is("pwd")));
    }
}
