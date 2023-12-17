package com.telemed.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientReadingRepository extends CrudRepository<PatientReading, Long> {
    List<PatientReading> findByUser(User user);
    Iterable<PatientReading> findAllByUser(User currentUser);
}
