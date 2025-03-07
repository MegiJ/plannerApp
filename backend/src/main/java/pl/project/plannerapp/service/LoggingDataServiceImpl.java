package pl.project.plannerapp.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.project.plannerapp.DTO.LoggingDataDTO;
import pl.project.plannerapp.domain.LoggingDataEntity;
import pl.project.plannerapp.model.AccountDetails;
import pl.project.plannerapp.model.LoggingData;
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


    @Autowired
    public LoggingDataServiceImpl(LoggingDataRepo loggingDataRepo) {
        this.loggingDataRepo = loggingDataRepo;
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
        AccountDetails accountDetails = createAccountDetails();
        loggingData.setAccountDetails(accountDetails);
        LoggingDataEntity loggingDataEntity = LoggingDataConventerUtils.convertToEntity(loggingData);
        LoggingDataEntity savedNewEntity = loggingDataRepo.save(loggingDataEntity);
        log.info("Saved new account with id " + savedNewEntity.getId());
        return savedNewEntity.getId();
    }

    private static AccountDetails createAccountDetails() {
        return AccountDetails.builder()
                .role(USER_ROLE)
                .isExpired(false)
                .isLocked(false)
                .isCredentialsExpired(false)
                .isDisabled(false)
                .build();
    }

    @Override
    public void update(Long id, LoggingDataDTO loggingDataDTO) {

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
