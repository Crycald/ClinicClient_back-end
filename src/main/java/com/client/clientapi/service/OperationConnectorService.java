package com.client.clientapi.service;

import com.client.clientapi.domain.OperationConnector;
import com.client.clientapi.domain.OperationConnectorDto;
import com.client.clientapi.mapper.OperationConnectorMapper;
import com.client.clientapi.repository.OperationConnectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OperationConnectorService {
    private OperationConnectorMapper mapper;
    private OperationConnectorRepository repository;

    @Autowired
    public OperationConnectorService(OperationConnectorMapper mapper, OperationConnectorRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    public List<OperationConnectorDto> getOperationConnectors() {
        return mapper.list(repository.findAll());
    }

    public OperationConnectorDto getOperationConnectorById(final Long id) {
        Optional<OperationConnector> operationConnector = repository.findById(id);
        return mapper.mapToDto(operationConnector.orElse(null));
    }

    public OperationConnectorDto createOperationConnector(final OperationConnectorDto operationConnectorDto) {
        operationConnectorDto.setId(null);
        OperationConnector operationConnector = mapper.map(operationConnectorDto);
        return mapper.mapToDto(repository.save(operationConnector));
    }

    public void deleteOperationConnector(final Long id) {
        repository.deleteById(id);
    }

    public OperationConnectorDto updateOperationConnector(final OperationConnectorDto operationConnectorDto) {
        repository.findById(operationConnectorDto.getId()).orElse(null);
        return mapper.mapToDto(repository.save(mapper.map(operationConnectorDto)));
    }
}
