package com.client.clientapi.controller;

import com.client.clientapi.domain.OperationDto;
import com.client.clientapi.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client/specializations")
@CrossOrigin("*")
public class ClinicOperationsController {
    private final OperationService service;

    @Autowired
    public ClinicOperationsController(OperationService service) {
        this.service = service;
    }

    @GetMapping(value = "/getSpecializations")
    public List<OperationDto> getSpecializations() {
        return service.getSpecializations();
    }

    @GetMapping(value = "/getSpecialization")
    public OperationDto getSpecializationById(@RequestParam Long id) {
        return service.getSpecializationById(id);
    }

    @PostMapping(value = "/createSpecialization")
    public OperationDto createSpecialization(@RequestBody OperationDto operationDto) {
        return service.createSpecialization(operationDto);
    }

    @DeleteMapping(value = "/deleteSpecialization")
    public void deleteSpecialization(@RequestParam Long id) {
        service.deleteSpecialization(id);
    }

    @PutMapping(value = "/updateSpecialization")
    public OperationDto updateSpecialization(@RequestBody OperationDto operationDto) {
        return service.updateSpecialization(operationDto);
    }
}
