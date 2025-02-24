package pl.project.plannerapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.project.plannerapp.DTO.PersonalDataDTO;
import pl.project.plannerapp.domain.LoggingDataEntity;
import pl.project.plannerapp.domain.PersonalDataEntity;
import pl.project.plannerapp.exceptions.AccountDetailsException;
import pl.project.plannerapp.model.PersonalData;
import pl.project.plannerapp.repo.LoggingDataRepo;
import pl.project.plannerapp.repo.PersonalDataRepo;
import pl.project.plannerapp.utils.PersonalDataConventerUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonalDataServiceImpl implements PersonalDataService {
    private final PersonalDataRepo personalDataRepo;
    private final LoggingDataRepo loggingDataRepo;

    @Autowired
    public PersonalDataServiceImpl(PersonalDataRepo personalDataRepo, LoggingDataRepo loggingDataRepo) {
        this.personalDataRepo = personalDataRepo;
        this.loggingDataRepo = loggingDataRepo;
    }

    @Override
    public List<PersonalData> getAllPersonalData() {
        return personalDataRepo.findAll()
                .stream()
                .map(PersonalDataConventerUtils::convert)
                .collect(Collectors.toList());
    }

    @Override
    public PersonalData addPersonalData(PersonalData personalDataToBeAdded) {
        LoggingDataEntity loggingDataEntity = loggingDataRepo.findById(personalDataToBeAdded.getLoggingDataId()).get();
        PersonalDataEntity savedNewPersonalDataEntity = personalDataRepo.save(PersonalDataConventerUtils.convertToEntity(personalDataToBeAdded, loggingDataEntity));
        PersonalData personalData = PersonalDataConventerUtils.convert(savedNewPersonalDataEntity);
        return personalData;
    }

    public void put(Long id, PersonalDataDTO personalDataDTO) {

    }

    @Override
    public void delete(Long id) {
        PersonalDataEntity personalDataEntity = personalDataRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        personalDataRepo.delete(personalDataEntity);
    }

    @Override
    public Optional<PersonalData> getById(Long id) {
        return personalDataRepo.findById(id)
                .map(PersonalDataConventerUtils::convert);
    }

    @Override
    public PersonalData getBySurname(String surname) {
        return personalDataRepo.findBySurname(surname)
                .map(PersonalDataConventerUtils::convert)
                .orElseThrow(()->new AccountDetailsException("Not found account details for surname: " + surname));
    }
}
