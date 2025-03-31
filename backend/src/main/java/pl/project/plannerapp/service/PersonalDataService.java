package pl.project.plannerapp.service;

import pl.project.plannerapp.DTO.PersonalDataDTO;
import pl.project.plannerapp.model.PersonalData;

import java.util.List;
import java.util.Optional;

public interface PersonalDataService {
    List<PersonalData> getAllPersonalData(); // GET - zwracanie

    PersonalData addPersonalData(PersonalData personalData);
    void put(Long id, PersonalDataDTO personalDataDTO);

    List<PersonalData> getBySurname(String surname);

    PersonalData modifySurname(Long personalDataId, String newSurname);

    void delete(Long id);
    Optional<PersonalData> getById(Long id);
}
