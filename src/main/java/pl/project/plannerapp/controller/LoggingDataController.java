package pl.project.plannerapp.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import pl.project.plannerapp.DTO.LogginDataDTO;
import pl.project.plannerapp.DTO.TrainingDTO;
import pl.project.plannerapp.service.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/loggingData", produces = MediaType.APPLICATION_JSON_VALUE)
public class LoggingDataController {
    interface LoggingDataView extends LogginDataDTO.View.Basic {}
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
    public List<LogginDataDTO> get() {
        return null;
    }

    @GetMapping("/{loggingData-id}")
    public LogginDataDTO get(@PathVariable int id) {
        return null;
    }

    @Transactional
    @PutMapping("/{loggingData-id}")
    public void put(@PathVariable int id, @RequestBody LogginDataDTO logginDataJson) {

    }

    @Transactional
    @DeleteMapping("/{loggingData-id}")
    public void delete(@PathVariable int id) {

    }
}
