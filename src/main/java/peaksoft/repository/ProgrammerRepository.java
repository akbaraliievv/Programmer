package peaksoft.repository;

import peaksoft.entity.Country;
import peaksoft.entity.Programmer;

import java.util.List;

public interface ProgrammerRepository {
    void saveProgrammer(Programmer programmer);
    List<Programmer>saveAll(List<Programmer> programmer);
    Programmer findById(Long programmerId);
    String deletedById(Long programmerId);
    void deletedAll();
    String updated(Programmer programmer,Long programmerId);
    Country countFrom(Long countryId);
    Programmer getYoungProgrammer();
    Programmer getOldProgrammer();
}
