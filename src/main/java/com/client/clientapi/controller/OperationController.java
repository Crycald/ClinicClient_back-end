package com.client.clientapi.controller;

import com.client.clientapi.domain.OperationDto;
import com.client.clientapi.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client/operations")
@CrossOrigin("*")
public class OperationController {
    private final OperationService service;

    @Autowired
    public OperationController(OperationService service) {
        this.service = service;
    }

    @GetMapping(value = "/getOperations")
    public List<OperationDto> getSpecializations() {
        return service.getSpecializations();
    }

    @GetMapping(value = "/getOperation")
    public OperationDto getSpecializationById(@RequestParam Long id) {
        return service.getSpecializationById(id);
    }

    @PostMapping(value = "/createOperation")
    public OperationDto createSpecialization(@RequestBody OperationDto operationDto) {
        return service.createSpecialization(operationDto);
    }

    @DeleteMapping(value = "/deleteOperation")
    public void deleteSpecialization(@RequestParam Long id) {
        service.deleteSpecialization(id);
    }

    @PutMapping(value = "/updateOperation")
    public OperationDto updateSpecialization(@RequestBody OperationDto operationDto) {
        return service.updateSpecialization(operationDto);
    }
}
