package com.client.clientapi.controller;

import com.client.clientapi.domain.OperationDto;
import com.client.clientapi.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
@CrossOrigin("*")
public class OperationController {
    private final OperationService service;

    @Autowired
    public OperationController(OperationService service) {
        this.service = service;
    }

    @GetMapping(value = "/operations")
    public List<OperationDto> getSpecializations() {
        return service.getSpecializations();
    }

    @GetMapping(value = "/operations/{id}")
    public OperationDto getSpecializationById(@PathVariable Long id) {
        return service.getSpecializationById(id);
    }

    @PostMapping(value = "/operations")
    public void createSpecialization(@RequestBody OperationDto operationDto) {
        service.createSpecialization(operationDto);
    }

    @DeleteMapping(value = "/operations/{id}")
    public void deleteSpecialization(@PathVariable Long id) {
        service.deleteSpecialization(id);
    }

    @PutMapping(value = "/operations")
    public OperationDto updateSpecialization(@RequestBody OperationDto operationDto) {
        return service.updateSpecialization(operationDto);
    }
}
