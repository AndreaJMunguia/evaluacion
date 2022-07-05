package com.evaluacion.java.parteuno.repository;

import com.evaluacion.java.parteuno.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
}
