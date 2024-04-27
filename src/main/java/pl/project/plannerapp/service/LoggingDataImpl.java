package pl.project.plannerapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.project.plannerapp.repo.AccountDetailsRepo;
import pl.project.plannerapp.repo.DietRepo;
import pl.project.plannerapp.repo.LoggingDataRepo;
import pl.project.plannerapp.repo.PersonalDataRepo;

@Service
public class LoggingDataImpl implements LoggingDataService {
    private final LoggingDataRepo loggingDataRepo;
    private final PersonalDataRepo personalDataRepo;
    private final AccountDetailsRepo accountDetailsRepo;

    @Autowired
    public LoggingDataImpl(LoggingDataRepo loggingDataRepo, PersonalDataRepo personalDataRepo, AccountDetailsRepo accountDetailsRepo) {
        this.loggingDataRepo = loggingDataRepo;
        this.personalDataRepo = personalDataRepo;
        this.accountDetailsRepo = accountDetailsRepo;
    }
}
