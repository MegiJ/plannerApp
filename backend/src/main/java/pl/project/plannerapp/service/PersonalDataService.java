package pl.project.plannerapp.service;

import pl.project.plannerapp.model.PersonalData;

import java.util.List;
import java.util.Optional;

public interface PersonalDataService {
    List<PersonalData> getAllPersonalData(); // GET - zwracanie

    List<PersonalData> getBySurname(String surname);

    Optional<PersonalData> getById(Long id);

    List<PersonalData> getByEmail(String email);

    PersonalData addPersonalData(PersonalData personalData);

    PersonalData modifySurname(Long personalDataId, String newSurname);

    PersonalData modifyFirstname(Long personalDataId, String newFirstname);

    PersonalData modifyPhone(Long personalDataId, int newPhone);

    PersonalData modifyEmail(Long personalDataId, String newEmail);

    void delete(Long id);
}
