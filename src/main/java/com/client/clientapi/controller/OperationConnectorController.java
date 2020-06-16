package com.client.clientapi.controller;

import com.client.clientapi.domain.OperationConnectorDto;
import com.client.clientapi.service.OperationConnectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/v1")
@CrossOrigin("*")
public class OperationConnectorController {
    private final OperationConnectorService service;

    @Autowired
    public OperationConnectorController(OperationConnectorService service) {
        this.service = service;
    }

    @GetMapping(value = "/operationLists")
    public List<OperationConnectorDto> getLists() {
        return service.getOperationConnectors();
    }

    @GetMapping(value = "/operationLists/{id}")
    public OperationConnectorDto getSingleList(@PathVariable Long id) {
        return service.getOperationConnectorById(id);
    }

    @PostMapping(value = "/operationLists")
    public void createList(@RequestBody OperationConnectorDto operationConnectorDto) {
        service.createOperationConnector(operationConnectorDto);
    }

    @DeleteMapping(value = "/operationLists/{id}")
    public void deleteList(@PathVariable Long id) {
        service.deleteOperationConnector(id);
    }

    @PutMapping(value = "/operationLists")
    public OperationConnectorDto updateList(@RequestBody OperationConnectorDto operationConnectorDto) {
        return service.updateOperationConnector(operationConnectorDto);
    }
}
