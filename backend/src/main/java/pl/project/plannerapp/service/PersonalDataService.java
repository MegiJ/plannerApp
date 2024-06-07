package pl.project.plannerapp.service;

import pl.project.plannerapp.DTO.PersonalDataDTO;
import pl.project.plannerapp.model.PersonalData;

import java.util.List;
import java.util.Optional;

public interface PersonalDataService {
    List<PersonalData> getAllPersonalData();

    void put (Long id, PersonalDataDTO personalDataDTO);

    void delete(Long id);

    Optional<PersonalData> getById(Long id);
}
