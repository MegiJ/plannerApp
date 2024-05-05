package pl.project.plannerapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.project.plannerapp.repo.PersonalDataRepo;

@Service
public class PersonalDataServiceImpl implements PersonalDataService {
    private final PersonalDataRepo personalDataRepo;

    @Autowired
    public PersonalDataServiceImpl(PersonalDataRepo personalDataRepo) {
        this.personalDataRepo = personalDataRepo;
    }
}
