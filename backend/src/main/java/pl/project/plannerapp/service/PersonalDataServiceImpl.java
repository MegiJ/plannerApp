package pl.project.plannerapp.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.server.ResponseStatusException;
import pl.project.plannerapp.domain.LoggingDataEntity;
import pl.project.plannerapp.domain.PersonalDataEntity;
import pl.project.plannerapp.exceptions.PersonalDataException;
import pl.project.plannerapp.model.PersonalData;
import pl.project.plannerapp.repo.LoggingDataRepo;
import pl.project.plannerapp.repo.PersonalDataRepo;
import pl.project.plannerapp.utils.PersonalDataConventerUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class PersonalDataServiceImpl implements PersonalDataService {
    private final PersonalDataRepo personalDataRepo;
    private final LoggingDataRepo loggingDataRepo;

    @Autowired
    public PersonalDataServiceImpl(PersonalDataRepo personalDataRepo, LoggingDataRepo loggingDataRepo) {
        this.personalDataRepo = personalDataRepo;
        this.loggingDataRepo = loggingDataRepo;
    }

    @GetMapping
    public List<PersonalData> getAllPersonalData() {
        return personalDataRepo.findAll()
                .stream()
                .map(PersonalDataConventerUtils::convert)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<PersonalData> getById(Long id) {
        return personalDataRepo.findById(id)
                .map(PersonalDataConventerUtils::convert);
    }

    @Override
    public List<PersonalData> getBySurname(String surname) {
        return personalDataRepo.findBySurname(surname)
                .stream()
                .map(PersonalDataConventerUtils::convert)
                .collect(Collectors.toList());
    }

    @Override
    public List<PersonalData> getByEmail(String email) {
        return personalDataRepo.findByEmail(email)
                .stream()
                .map(PersonalDataConventerUtils::convert)
                .collect(Collectors.toList());
    }

    @Override
    public PersonalData addPersonalData(PersonalData personalDataToBeAdded) {
        LoggingDataEntity loggingDataEntity = loggingDataRepo.findById(personalDataToBeAdded.getLoggingDataId()).get();
        PersonalDataEntity savedNewPersonalData = personalDataRepo.save(PersonalDataConventerUtils.convertToEntity(personalDataToBeAdded, loggingDataEntity));
        PersonalData personalDataWithId = PersonalDataConventerUtils.convert(savedNewPersonalData);
        return personalDataWithId;
    }

    @Override
    public PersonalData modifySurname(Long personalDataId, String newSurname) {
        Optional<PersonalDataEntity> personalDataOptional = personalDataRepo.findById(personalDataId); // krok 1a: szukanie w bazie danych po id
        if (personalDataOptional.isEmpty()) { // 1b: sprawdz czy czlwieik istnieje
            log.warn("Personal data " + personalDataId + " not found");
            throw new PersonalDataException("Personal data not found");
        }
        PersonalDataEntity currentData = personalDataOptional.get(); // krok 1c:  pokaz te dane
        currentData.setSurname(newSurname); //krok 2: podmień nazwisko
        PersonalDataEntity personalDataEntity = personalDataRepo.save(currentData); //krok 3: zapis do bazy
        return PersonalDataConventerUtils.convert(personalDataEntity);
    }

    @Override
    public PersonalData modifyFirstname(Long personalDataId, String newFirstname) {
        Optional<PersonalDataEntity> personalDataOptional = personalDataRepo.findById(personalDataId); // krok 1a: szukanie w bazie danych po id
        if (personalDataOptional.isEmpty()) { // 1b: sprawdz czy czlwieik istnieje
            log.warn("Personal data " + personalDataId + " not found");
            throw new PersonalDataException("Personal data not found");
        }
        PersonalDataEntity currentData = personalDataOptional.get(); // krok 1c:  pokaz te dane
        currentData.setFirstname(newFirstname); //krok 2: podmień nazwisko
        PersonalDataEntity personalDataEntity = personalDataRepo.save(currentData); //krok 3: zapis do bazy
        return PersonalDataConventerUtils.convert(personalDataEntity);
    }

    @Override
    public PersonalData modifyPhone(Long personalDataId, int newPhone) {
        Optional<PersonalDataEntity> personalDataOptional = personalDataRepo.findById(personalDataId);
        if (personalDataOptional.isEmpty()) {
            log.warn("Personal data " + personalDataId + " not found");
            throw new PersonalDataException("Personal data not found");
        }
        PersonalDataEntity currentData = personalDataOptional.get();
        currentData.setPhone(newPhone);
        PersonalDataEntity personalDataEntity = personalDataRepo.save(currentData);
        return PersonalDataConventerUtils.convert(personalDataEntity);
    }

    @Override
    public PersonalData modifyEmail(Long personalDataId, String newEmail) {
        Optional<PersonalDataEntity> personalDataOptional = personalDataRepo.findById(personalDataId);
        if (personalDataOptional.isEmpty()) {
            log.warn("Personal data " + personalDataId + " not found");
            throw new PersonalDataException("Personal data not found");
        }
        List<PersonalDataEntity> allPersonalData = personalDataRepo.findAll();
        if (allPersonalData.contains(newEmail)) {
            log.warn("Email: " + newEmail + " already exist");
            throw new PersonalDataException("Email already exist");
        }
        PersonalDataEntity currentData = personalDataOptional.get();
        currentData.setEmail(newEmail);
        PersonalDataEntity personalDataEntity = personalDataRepo.save(currentData); //krok 3: zapis do bazy
        return PersonalDataConventerUtils.convert(personalDataEntity);
    }

    @Override
    public void delete(Long id) {
        PersonalDataEntity personalDataEntity = personalDataRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        personalDataRepo.delete(personalDataEntity);
    }
}
