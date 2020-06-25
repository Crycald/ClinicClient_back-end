package com.client.clientapi.controller;

import com.client.clientapi.domain.ClinicDto;
import com.client.clientapi.domain.enums.TypeOfAnimal;
import com.client.clientapi.service.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
@CrossOrigin("*")
public class ClinicController {
    private final ClinicService service;

    @Autowired
    public ClinicController(ClinicService service) {
        this.service = service;
    }

    @GetMapping(value = "/clinics")
    public List<ClinicDto> getClinics() {
        return service.getClinics();
    }

    @GetMapping(value = "/clinics/{id}")
    public ClinicDto getClinicById(@PathVariable Long id) {
        return service.getClinicById(id);
    }

    @PostMapping(value = "/clinics")
    public void createClinic(@RequestBody ClinicDto clinicDto) {
        service.createClinic(clinicDto);
    }

    @DeleteMapping(value = "/clinics/{id}")
    public void deleteClinic(@PathVariable Long id) {
        service.deleteClinic(id);
    }

    @PutMapping(value = "/clinics")
    public ClinicDto updateClinic(@RequestBody ClinicDto clinicDto) {
        return service.updateClinic(clinicDto);
    }

    @GetMapping(value = "/clinics/validate/{login}&{password}")
    public Long validateClinic(@PathVariable String login, @PathVariable String password) {
        return service.validateClinicAndReturnId(login, password);
    }

    @GetMapping(value = "/clinics/animal/{type}")
    public List<ClinicDto> getClinicsName(@PathVariable TypeOfAnimal type) {
        return service.getClinicsByTypeOfAnimal(type);
    }

    @GetMapping(value = "/clinics/validateLogin/{login}")
    public Boolean validateClinicLogin(@PathVariable String login) {
        return service.validateClinicLogin(login);
    }
}
