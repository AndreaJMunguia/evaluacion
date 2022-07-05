package com.evaluacion.java.parteuno.service;

import com.evaluacion.java.parteuno.model.Airport;
import java.util.List;

public interface AirportService {

    Airport createAirport(Airport airport);

    Airport updateAirport(Airport airport);

    List<Airport> getAllAirports();

    Airport getAirportById(long airportId);

    void deleteAirport(long id);

}
