package pl.project.plannerapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.project.plannerapp.DTO.LoggingDataDTO;
import pl.project.plannerapp.service.AccountDetailsService;
import pl.project.plannerapp.service.LoggingDataService;
import pl.project.plannerapp.utils.LoggingDataConventerUtils;

import java.util.List;

@RestController
@RequestMapping(path = "/api/loggingData", produces = MediaType.APPLICATION_JSON_VALUE)
public class LoggingDataController {
    private final LoggingDataService loggingDataService;
    private final AccountDetailsService accountDetailsService;


    @Autowired
    public LoggingDataController(LoggingDataService loggingDataService, AccountDetailsService accountDetailsService) {
        this.loggingDataService = loggingDataService;
        this.accountDetailsService = accountDetailsService;
    }

    @GetMapping
    public List<LoggingDataDTO> getAllLoggingDatas() {
        return loggingDataService.getAllLoginData().stream().map(a -> LoggingDataConventerUtils.convert(a)).toList();
    }

    @GetMapping("/{loggingDataId}")
    public LoggingDataDTO getLoggingDataById(@PathVariable Long loggingDataId) {
        return loggingDataService.getById(loggingDataId).map(a -> LoggingDataConventerUtils.convert(a))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public long saveNewAccount(@RequestBody LoggingDataDTO loggingDataDTO) {
        return loggingDataService.save(LoggingDataConventerUtils.convert(loggingDataDTO));
    }


    @PutMapping("/{loggingDataId}")
    public void put(@PathVariable Long id, @RequestBody LoggingDataDTO loggingDataJson) {

    }


    @DeleteMapping("/{loggingDataId}")
    public void delete(@PathVariable Long id) {

    }
}
