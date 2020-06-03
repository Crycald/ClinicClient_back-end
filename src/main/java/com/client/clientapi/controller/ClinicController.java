package com.client.clientapi.controller;

import com.client.clientapi.domain.ClinicDto;
import com.client.clientapi.service.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client/clinics")
@CrossOrigin("*")
public class ClinicController {
    private final ClinicService service;

    @Autowired
    public ClinicController(ClinicService service) {
        this.service = service;
    }

    @GetMapping(value = "/getClinics")
    public List<ClinicDto> getClinics() {
        return service.getClinics();
    }

    @GetMapping(value = "/getClinic")
    public ClinicDto getClinicById(@RequestParam Long id) {
        return service.getClinicById(id);
    }

    @PostMapping(value = "/createClinic")
    public ClinicDto createClinic(@RequestBody ClinicDto clinicDto) {
        return service.createClinic(clinicDto);
    }

    @DeleteMapping(value = "/deleteClinic")
    public void deleteClinic(@RequestParam Long id) {
        service.deleteClinic(id);
    }

    @PutMapping(value = "/updateClinic")
    public ClinicDto updateClinic(@RequestBody ClinicDto clinicDto) {
        return service.updateClinic(clinicDto);
    }
}
