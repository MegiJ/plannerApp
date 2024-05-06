package pl.project.plannerapp.service;

import pl.project.plannerapp.DTO.LoggingDataDTO;
import pl.project.plannerapp.DTO.PersonalDataDTO;

import java.util.List;
import java.util.Optional;

public interface PersonalDataService {
    List<PersonalDataDTO> getAll();

    void put (Long id, PersonalDataDTO personalDataDTO);

    void delete(Long id);

    Optional<PersonalDataDTO> getById(Long id);
}
