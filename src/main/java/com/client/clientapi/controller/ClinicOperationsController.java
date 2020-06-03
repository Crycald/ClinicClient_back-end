package com.client.clientapi.controller;

import com.client.clientapi.domain.OperationActDto;
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
    public List<OperationActDto> getSpecializations() {
        return service.getSpecializations();
    }

    @GetMapping(value = "/getSpecialization")
    public OperationActDto getSpecializationById(@RequestParam Long id) {
        return service.getSpecializationById(id);
    }

    @PostMapping(value = "/createSpecialization")
    public OperationActDto createSpecialization(@RequestBody OperationActDto operationActDto) {
        return service.createSpecialization(operationActDto);
    }

    @DeleteMapping(value = "/deleteSpecialization")
    public void deleteSpecialization(@RequestParam Long id) {
        service.deleteSpecialization(id);
    }

    @PutMapping(value = "/updateSpecialization")
    public OperationActDto updateSpecialization(@RequestBody OperationActDto operationActDto) {
        return service.updateSpecialization(operationActDto);
    }
}
