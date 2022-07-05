package com.evaluacion.java.parteuno.service;

import com.evaluacion.java.parteuno.model.Country;
import java.util.List;

public interface CountryService {
    Country createCountry(Country country);
    Country updateCountry(Country country);
    List<Country> getAllCountry();
    Country getCountryById(long countryId);
    void deleteCountry(long id);
}
