package peaksoft.service;

import peaksoft.entity.Country;

import java.util.List;

public interface CountryService {
    void saveCountry(Country country);
    List<Country> saveAllCountry(List<Country> country);
    List<Country> findAll();
    Country findById(Long countryId);
    String deletedById(Long countryId);
    void deletedAll();
    String updated(Country country, Long countryId);
    Country longByDescription();
    Integer getSameCountryProgrammer(String country);
}
