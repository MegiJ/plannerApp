package pl.project.plannerapp.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.project.plannerapp.domain.AccountDetailsEntity;
import pl.project.plannerapp.domain.LoggingDataEntity;
import pl.project.plannerapp.exceptions.LoggingDataException;
import pl.project.plannerapp.model.LoggingData;
import pl.project.plannerapp.repo.AccountDetailsRepo;
import pl.project.plannerapp.repo.LoggingDataRepo;
import pl.project.plannerapp.utils.LoggingDataConventerUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class LoggingDataServiceImpl implements LoggingDataService {
    public static final String USER_ROLE = "user";
    private final LoggingDataRepo loggingDataRepo;
    private final AccountDetailsRepo accountDetailsRepo;

    @Autowired
    public LoggingDataServiceImpl(LoggingDataRepo loggingDataRepo, AccountDetailsRepo accountDetailsRepo) {
        this.loggingDataRepo = loggingDataRepo;
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
    public LoggingData saveNewLoggingData(LoggingData loggingDataToBeAdded) {
        AccountDetailsEntity accountDetailsEntity = AccountDetailsEntity.builder()
                .role(USER_ROLE)
                .isExpired(false)
                .isLocked(false)
                .isCredentialsExpired(false)
                .isDisabled(false)
                .build();
        LoggingDataEntity loggingDataToBeSaved = LoggingDataConventerUtils.convertToEntity(loggingDataToBeAdded, accountDetailsEntity);
        LoggingDataEntity savedNewLoggingData = loggingDataRepo.save(loggingDataToBeSaved);
        LoggingData loggingDataWithId = LoggingDataConventerUtils.convert(savedNewLoggingData);
        return loggingDataWithId;
    }

    @Override
    public LoggingData modifyPassword(Long loggingDataId, String newPassword) {
        Optional<LoggingDataEntity> loggingDataOptional = loggingDataRepo.findById(loggingDataId);
        if (loggingDataOptional.isEmpty()) {
            log.warn("Logging data " + loggingDataId + " not found");
            throw new LoggingDataException("Logging data not found");
        }
        LoggingDataEntity currentPassword = loggingDataOptional.get();
        currentPassword.setPassword(newPassword);
        LoggingDataEntity loggingDataEntity = loggingDataRepo.save(currentPassword);
        return LoggingDataConventerUtils.convert(loggingDataEntity);
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
