package pl.project.plannerapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.project.plannerapp.DTO.LogginDataDTO;
import pl.project.plannerapp.repo.AccountDetailsRepo;
import pl.project.plannerapp.repo.LoggingDataRepo;
import pl.project.plannerapp.repo.PersonalDataRepo;
import pl.project.plannerapp.utils.ConventerUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoggingDataServiceImpl implements LoggingDataService {
    private final LoggingDataRepo loggingDataRepo;
    private final PersonalDataRepo personalDataRepo;
    private final AccountDetailsRepo accountDetailsRepo;

    @Autowired
    public LoggingDataServiceImpl(LoggingDataRepo loggingDataRepo, PersonalDataRepo personalDataRepo, AccountDetailsRepo accountDetailsRepo) {
        this.loggingDataRepo = loggingDataRepo;
        this.personalDataRepo = personalDataRepo;
        this.accountDetailsRepo = accountDetailsRepo;
    }

    @Override
    public List<LogginData> getAll() {
        return loggingDataRepo.findAll();
    }
}
