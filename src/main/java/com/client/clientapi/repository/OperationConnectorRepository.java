package com.client.clientapi.repository;

import com.client.clientapi.domain.OperationConnector;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface OperationConnectorRepository extends CrudRepository<OperationConnector, Long> {

    @Override
    List<OperationConnector> findAll();

    @Override
    Optional<OperationConnector> findById(Long id);

    @Override
    OperationConnector save(OperationConnector operationConnector);

    @Override
    void deleteById(Long id);

    List<OperationConnector> findAllByCustomerId_Id(Long id);

    List<OperationConnector> findAllByClinicId_Id(Long id);
}
