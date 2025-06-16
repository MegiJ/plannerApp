package pl.project.plannerapp.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.project.plannerapp.DTO.LoggingDataDTORequest;
import pl.project.plannerapp.DTO.LoggingDataDTOResponse;
import pl.project.plannerapp.model.LoggingData;
import pl.project.plannerapp.service.LoggingDataService;
import pl.project.plannerapp.utils.LoggingDataConventerUtils;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(path = "/api/loggingData", produces = MediaType.APPLICATION_JSON_VALUE)
public class LoggingDataController {
    private final LoggingDataService loggingDataService;

    @Autowired
    public LoggingDataController(LoggingDataService loggingDataService) {
        this.loggingDataService = loggingDataService;
    }

    @GetMapping
    public List<LoggingDataDTOResponse> getAllLoggingDatas() {
        return loggingDataService.getAllLoginData().stream()
                .map(LoggingDataConventerUtils::convert)
                .toList();
    }

    @GetMapping("/{loggingDataId}")
    public ResponseEntity<LoggingDataDTOResponse> getLoggingDataById(@PathVariable Long loggingDataId) {
        Optional<LoggingDataDTOResponse> loggingDataDTOResponse = loggingDataService.getById(loggingDataId)
                .map(LoggingDataConventerUtils::convert);
        return loggingDataDTOResponse.map(dataDTOResponse -> new ResponseEntity<>(dataDTOResponse, HttpStatus.OK))
                                     .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public long saveNewAccount(@RequestBody LoggingDataDTORequest loggingDataJson) {
        LoggingData loggingDataWithId = loggingDataService.saveNewLoggingData(LoggingDataConventerUtils.convert(loggingDataJson));
        return loggingDataWithId.getLoggingDataId();
    }

    @PutMapping("/{loggingDataId}/password")
    public ResponseEntity<LoggingDataDTOResponse> updatePassword(@PathVariable Long loggingDataId, @RequestBody String newPassword) {
        LoggingData oldPassword = loggingDataService.modifyPassword(loggingDataId, newPassword);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{loggingDataId}")
    public void delete(@PathVariable Long loggingDataId) {
        loggingDataService.delete(loggingDataId);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> handleException(
            ConstraintViolationException exception, HttpServletRequest httpServletRequest
    ) {
        log.warn(
                "Hasło nie spełnia wymagań. Exception: {}, error message: {}",
                httpServletRequest.getRequestURI(),
                exception.getMessage()
        );
        return new ResponseEntity<>("Something bad", HttpStatus.BAD_REQUEST);
    }
}
