package com.client.clientapi.controller;

import com.client.clientapi.domain.ClinicDto;
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
    public ClinicDto createClinic(@RequestBody ClinicDto clinicDto) {
        return service.createClinic(clinicDto);
    }

    @DeleteMapping(value = "/clinics/{id}")
    public void deleteClinic(@PathVariable Long id) {
        service.deleteClinic(id);
    }

    @PutMapping(value = "/clinics")
    public ClinicDto updateClinic(@RequestBody ClinicDto clinicDto) {
        return service.updateClinic(clinicDto);
    }
}
