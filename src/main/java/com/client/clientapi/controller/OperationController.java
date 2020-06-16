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
    public List<OperationDto> getOperations() {
        return service.getOperations();
    }

    @GetMapping(value = "/operations/{id}")
    public OperationDto getOperationById(@PathVariable Long id) {
        return service.getOperationById(id);
    }

    @PostMapping(value = "/operations")
    public void createOperation(@RequestBody OperationDto operationDto) {
        service.createOperation(operationDto);
    }

    @DeleteMapping(value = "/operations/{id}")
    public void deleteOperation(@PathVariable Long id) {
        service.deleteOperation(id);
    }

    @PutMapping(value = "/operations")
    public OperationDto updateOperation(@RequestBody OperationDto operationDto) {
        return service.updateOperation(operationDto);
    }
}
