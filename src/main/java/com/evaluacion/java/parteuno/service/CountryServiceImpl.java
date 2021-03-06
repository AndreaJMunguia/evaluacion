package com.evaluacion.java.parteuno.service;

import com.evaluacion.java.parteuno.exception.ResourceNotFoundException;
import com.evaluacion.java.parteuno.model.Country;
import com.evaluacion.java.parteuno.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CountryServiceImpl implements CountryService{

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public Country createCountry(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public Country updateCountry(Country country) {
        Optional<Country> countryDb = this.countryRepository.findById(country.getCountry_id());
        if (countryDb.isPresent()){
            Country countryUpdate = countryDb.get();
            countryUpdate.setCountry_id(country.getCountry_id());
            countryUpdate.setCode(country.getCode());
            countryUpdate.setName(country.getName());
            countryRepository.save(countryUpdate);
            return countryUpdate;
        } else {
            throw new ResourceNotFoundException("Record not found with id: " + country.getCountry_id());
        }
    }

    @Override
    public List<Country> getAllCountry() {
        return this.countryRepository.findAll();
    }

    @Override
    public Country getCountryById(long countryId) {
        Optional<Country> countryDb = this.countryRepository.findById(countryId);
        if(countryDb.isPresent()){
            return countryDb.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id: " + countryId);
        }
    }

    @Override
    public void deleteCountry(long countryId) {
        Optional<Country> countryDb = this.countryRepository.findById(countryId);
        if(countryDb.isPresent()){
            this.countryRepository.delete(countryDb.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id: " + countryId);
        }
    }
}
