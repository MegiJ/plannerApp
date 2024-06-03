package pl.project.plannerapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.project.plannerapp.DTO.LoggingDataDTO;
import pl.project.plannerapp.service.AccountDetailsService;
import pl.project.plannerapp.service.LoggingDataService;
import pl.project.plannerapp.service.PersonalDataService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/loggingData", produces = MediaType.APPLICATION_JSON_VALUE)
public class LoggingDataController {
    private final LoggingDataService loggingDataService;
    private final PersonalDataService personalDataService;
    private final AccountDetailsService accountDetailsService;
    private final ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    public LoggingDataController(LoggingDataService loggingDataService, PersonalDataService personalDataService, AccountDetailsService accountDetailsService, ApplicationEventPublisher applicationEventPublisher) {
        this.loggingDataService = loggingDataService;
        this.personalDataService = personalDataService;
        this.accountDetailsService = accountDetailsService;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @GetMapping
    public List<LoggingDataDTO> get() {
        return null;
    }

    @GetMapping("/{loggingData-id}")
    public LoggingDataDTO get(@PathVariable Long id) {
        return loggingDataService.getById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Transactional
    @PutMapping("/{loggingData-id}")
    public void put(@PathVariable Long id, @RequestBody LoggingDataDTO loggingDataJson) {

    }

    @Transactional
    @DeleteMapping("/{loggingData-id}")
    public void delete(@PathVariable Long id) {

    }
}
