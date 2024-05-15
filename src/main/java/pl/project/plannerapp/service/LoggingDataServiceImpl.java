package pl.project.plannerapp.service;

import com.google.common.base.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.project.plannerapp.DTO.LoggingDataDTO;
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
    public List<LoggingDataDTO> getAll() {
        return loggingDataRepo.findAll()
                .stream()
                .map(LoggingDataConventerUtils::convert)
                .collect(Collectors.toList());
    }

    @Override
    public void put(Long id, LoggingDataDTO loggingDataDTO) {

    }

    @Override
    public void delete(Long id) {
        LoggingData loggingData = loggingDataRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        loggingDataRepo.delete(loggingData);
    }

    @Override
    public Optional<LoggingDataDTO> getById(Long id) {
        return loggingDataRepo.findById(id).map(LoggingDataConventerUtils::convert);
    }

    @Override
    public void validateNewOperation(Long id, LoggingDataDTO loggingDataDTO) {
        if(!Objects.equal(loggingDataDTO.getId(), id)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        loggingDataRepo.findById(loggingDataDTO.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
