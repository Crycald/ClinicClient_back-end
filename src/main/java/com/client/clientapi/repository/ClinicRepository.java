package com.client.clientapi.repository;

import com.client.clientapi.domain.Clinic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface ClinicRepository extends CrudRepository<Clinic, Long> {

    @Override
    List<Clinic> findAll();

    @Override
    Clinic save(Clinic clinic);

    @Override
    Optional<Clinic> findById(Long id);

    @Override
    void deleteById(Long id);
}
