package pl.project.plannerapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.project.plannerapp.DTO.LoggingDataDTO;
import pl.project.plannerapp.domain.LoggingDataEntity;
import pl.project.plannerapp.model.LoggingData;
import pl.project.plannerapp.repo.AccountDetailsRepo;
import pl.project.plannerapp.repo.LoggingDataRepo;
import pl.project.plannerapp.repo.PersonalDataRepo;
import pl.project.plannerapp.utils.LoggingDataConventerUtils;

import java.util.List;
import java.util.Optional;
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
    public List<LoggingData> getAllLoginData() {
        return loggingDataRepo.findAll()
                .stream()
                .map(LoggingDataConventerUtils::convert)
                .collect(Collectors.toList());
    }

    @Override
    public long save(LoggingData loggingData) {
        LoggingDataEntity savedNewEntity = loggingDataRepo.save(LoggingDataConventerUtils.convertToEntity(loggingData));
        return savedNewEntity.getId();
    }

    @Override
    public void put(Long id, LoggingDataDTO loggingDataDTO) {

    }

    @Override
    public void delete(Long id) {
        LoggingDataEntity loggingDataEntity = loggingDataRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        loggingDataRepo.delete(loggingDataEntity);
    }

    @Override
    public Optional<LoggingData> getById(Long id) {
        return loggingDataRepo.findById(id)
                .map(LoggingDataConventerUtils::convert);
    }
}
