package com.evaluacion.java.parteuno.repository;

import com.evaluacion.java.parteuno.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends JpaRepository<Airport,Long> {
}
