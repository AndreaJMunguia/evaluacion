package com.evaluacion.java.parteuno.controller;

import com.evaluacion.java.parteuno.exception.Mensaje;
import com.evaluacion.java.parteuno.model.Country;
import com.evaluacion.java.parteuno.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {
    @Autowired
    private CountryService countryService;

    @GetMapping("/listacountries")
    public ResponseEntity<?> getAllCountry(){
        List<Country> lista = countryService.getAllCountry();
        if(lista.isEmpty()) {
            return new ResponseEntity<>(new Mensaje("Sin countries en la base de datos"), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok().body(countryService.getAllCountry());
    }

    @GetMapping("/detallecountry/{id}")
    public ResponseEntity<Country> getCountryById(@PathVariable long id){
        return ResponseEntity.ok().body(countryService.getCountryById(id));
    }

    @PostMapping("crearcountry")
    public ResponseEntity<Country> createCountry(@RequestBody Country country) {
        return ResponseEntity.ok().body(this.countryService.createCountry(country));
    }

    @PutMapping("actualizarcountry/{id}")
    public ResponseEntity<Country> updateCountry(@PathVariable long id, @RequestBody Country country) {
        country.setId(id);
        return ResponseEntity.ok().body(this.countryService.updateCountry(country));
    }

    @DeleteMapping("eliminarcountry/{id}")
    public HttpStatus deleteCountry(@PathVariable long id) {
        this.countryService.deleteCountry(id);
        return HttpStatus.OK;
    }
}
