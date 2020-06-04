package com.client.clientapi.controller;

import com.client.clientapi.domain.OperationConnectorDto;
import com.client.clientapi.service.OperationConnectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/operationConnector/lists")
@CrossOrigin("*")
public class OperationConnectorController {
    private final OperationConnectorService service;

    @Autowired
    public OperationConnectorController(OperationConnectorService service) {
        this.service = service;
    }

    @GetMapping(value = "/getLists")
    public List<OperationConnectorDto> getLists() {
        return service.getOperationConnectors();
    }

    @GetMapping(value = "/getList")
    public OperationConnectorDto getSingleList(@RequestParam Long id) {
        return service.getOperationConnectorById(id);
    }

    @PostMapping(value = "/createList")
    public OperationConnectorDto createList(@RequestBody OperationConnectorDto operationConnectorDto) {
        return service.createOperationConnector(operationConnectorDto);
    }

    @DeleteMapping(value = "/deleteList")
    public void deleteList(@RequestParam Long id) {
        service.deleteOperationConnector(id);
    }

    @PutMapping(value = "/updateList")
    public OperationConnectorDto updateList(@RequestBody OperationConnectorDto operationConnectorDto) {
        return service.updateOperationConnector(operationConnectorDto);
    }
}
