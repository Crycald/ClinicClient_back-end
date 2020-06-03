package com.client.clientapi.repository;

import com.client.clientapi.domain.OperationAct;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface ClinicOperationsRepository extends CrudRepository<OperationAct, Long> {

    @Override
    List<OperationAct> findAll();

    @Override
    OperationAct save(OperationAct operationAct);

    @Override
    Optional<OperationAct> findById(Long id);

    @Override
    void deleteById(Long id);
}
