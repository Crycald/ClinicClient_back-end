package com.client.clientapi.repository;

import com.client.clientapi.domain.ClinicOperations;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface ClinicOperationsRepository extends CrudRepository<ClinicOperations, Long> {

    @Override
    List<ClinicOperations> findAll();

    @Override
    ClinicOperations save(ClinicOperations clinicOperations);

    @Override
    Optional<ClinicOperations> findById(Long id);

    @Override
    void deleteById(Long id);
}
