package com.client.clientapi.repository;

import com.client.clientapi.domain.Operation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface OperationRepository extends CrudRepository<Operation, Long> {

    @Override
    List<Operation> findAll();

    @Override
    Operation save(Operation operation);

    @Override
    Optional<Operation> findById(Long id);

    @Override
    void deleteById(Long id);
}
