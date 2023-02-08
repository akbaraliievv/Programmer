package peaksoft.service;

import peaksoft.entity.Country;
import peaksoft.entity.Programmer;
import peaksoft.repository.ProgrammerRepository;
import peaksoft.repository.ProgrammerRepositoryImpl;

import java.util.List;

public class ProgrammerServiceImpl implements ProgrammerService{
    ProgrammerRepository repository = new ProgrammerRepositoryImpl();
    @Override
    public void saveProgrammer(Programmer programmer) {
        repository.saveProgrammer(programmer);
    }

    @Override
    public List<Programmer> saveAll(List<Programmer> programmer) {
        return repository.saveAll(programmer);
    }

    @Override
    public Programmer findById(Long programmerId) {
        return repository.findById(programmerId);
    }

    @Override
    public String deletedById(Long programmerId) {
        return repository.deletedById(programmerId);
    }

    @Override
    public void deletedAll() {
       repository.deletedAll();
    }

    @Override
    public String updated(Programmer programmer, Long programmerId) {
        return repository.updated(programmer,programmerId);
    }

    @Override
    public Country countFrom(Long countryId) {
       return repository.countFrom(countryId);
    }

    @Override
    public Programmer getYoungProgrammer() {
        return repository.getYoungProgrammer();
    }

    @Override
    public Programmer getOldProgrammer() {
        return repository.getOldProgrammer();
    }
}
