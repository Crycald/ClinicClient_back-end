package com.client.clientapi.controller;

import com.client.clientapi.domain.ClinicOperationsDto;
import com.client.clientapi.service.ClinicOperationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client/specializations")
@CrossOrigin("*")
public class ClinicOperationsController {
    private final ClinicOperationsService service;

    @Autowired
    public ClinicOperationsController(ClinicOperationsService service) {
        this.service = service;
    }

    @GetMapping(value = "/getSpecializations")
    public List<ClinicOperationsDto> getSpecializations() {
        return service.getSpecializations();
    }

    @GetMapping(value = "/getSpecialization")
    public ClinicOperationsDto getSpecializationById(@RequestParam Long id) {
        return service.getSpecializationById(id);
    }

    @PostMapping(value = "/createSpecialization")
    public ClinicOperationsDto createSpecialization(@RequestBody ClinicOperationsDto clinicOperationsDto) {
        return service.createSpecialization(clinicOperationsDto);
    }

    @DeleteMapping(value = "/deleteSpecialization")
    public void deleteSpecialization(@RequestParam Long id) {
        service.deleteSpecialization(id);
    }

    @PutMapping(value = "/updateSpecialization")
    public ClinicOperationsDto updateSpecialization(@RequestBody ClinicOperationsDto clinicOperationsDto) {
        return service.updateSpecialization(clinicOperationsDto);
    }
}
