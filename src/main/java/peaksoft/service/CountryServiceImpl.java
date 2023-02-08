package peaksoft.service;

import peaksoft.entity.Country;
import peaksoft.repository.CountryRepository;
import peaksoft.repository.CountryRepositoryImpl;

import java.util.List;

public class CountryServiceImpl implements CountryService {
    CountryRepository countryRepository = new CountryRepositoryImpl();
    @Override
    public void saveCountry(Country country) {
        countryRepository.saveCountry(country);
    }

    @Override
    public List<Country> saveAllCountry(List<Country> country) {
        return countryRepository.saveAllCountry(country);
    }

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Country findById(Long countryId) {
        return countryRepository.findById(countryId);
    }

    @Override
    public String deletedById(Long countryId) {
        return countryRepository.deletedById(countryId);
    }

    @Override
    public void deletedAll() {
        countryRepository.deletedAll();
    }

    @Override
    public String updated(Country country, Long countryId) {
        return countryRepository.updated(country,countryId);
    }

    @Override
    public Country longByDescription() {
        return countryRepository.longByDescription();
    }

    @Override
    public Integer getSameCountryProgrammer(String country) {
        return countryRepository.getSameCountryProgrammer(country);
    }
}
