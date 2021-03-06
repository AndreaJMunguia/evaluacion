package com.evaluacion.java.parteuno.service;

import com.evaluacion.java.parteuno.exception.ResourceNotFoundException;
import com.evaluacion.java.parteuno.model.Airport;
import com.evaluacion.java.parteuno.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AirportServiceImpl implements AirportService {

    @Autowired
    private AirportRepository airportRepository;

    @Override
    public Airport createAirport(Airport airport) {
        return airportRepository.save(airport);
    }

    @Override
    public Airport updateAirport(Airport airport) {
        Optional<Airport> airportDb = this.airportRepository.findById(airport.getAirport_id());

        if (airportDb.isPresent()){
            Airport airportUpdate = airportDb.get();
            airportUpdate.setAirport_id(airport.getAirport_id());
            airportUpdate.setName(airport.getName());
            airportRepository.save(airportUpdate);
            return airportUpdate;
        }else {
            throw new ResourceNotFoundException("Record not found with id : " + airport.getAirport_id());
        }
    }

    @Override
    public List<Airport> getAllAirports() {
        return this.airportRepository.findAll();
    }

    @Override
    public Airport getAirportById(long airportId) {
        Optional<Airport> airportDb = this.airportRepository.findById(airportId);

        if (airportDb.isPresent()) {
            return airportDb.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + airportId);
        }
    }

    @Override
    public void deleteAirport(long airportId) {
        Optional<Airport> airportDb = this.airportRepository.findById(airportId);

        if (airportDb.isPresent()) {
            this.airportRepository.delete(airportDb.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id: " + airportId);
        }
    }
}
