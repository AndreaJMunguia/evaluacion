package com.evaluacion.java.parteuno.controller;

import com.evaluacion.java.parteuno.exception.Mensaje;
import com.evaluacion.java.parteuno.model.Airport;
import com.evaluacion.java.parteuno.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airport")
public class AirportController {
    @Autowired
    private AirportService airportService;

    @GetMapping("/listaairports")
    public ResponseEntity<?> getAllAirport(){
        List<Airport> lista = airportService.getAllAirports();
        if(lista.isEmpty()) {
            return new ResponseEntity<>(new Mensaje("Sin airports en la base de datos"), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok().body(airportService.getAllAirports());
    }

    @GetMapping("/detalleairport/{id}")
    public ResponseEntity<Airport> getAirportById(@PathVariable long id){
        return ResponseEntity.ok().body(airportService.getAirportById(id));
    }

    @PostMapping("crearairport")
    public ResponseEntity<Airport> createAirport(@RequestBody Airport airport) {
        return ResponseEntity.ok().body(this.airportService.createAirport(airport));
    }

    @PutMapping("actualizarairport/{id}")
    public ResponseEntity<Airport> updateAirport(@PathVariable long id, @RequestBody Airport airport) {
        airport.setId(id);
        return ResponseEntity.ok().body(this.airportService.updateAirport(airport));
    }

    @DeleteMapping("eliminarairport/{id}")
    public HttpStatus deleteAirport(@PathVariable long id) {
        this.airportService.deleteAirport(id);
        return HttpStatus.OK;
    }
}
