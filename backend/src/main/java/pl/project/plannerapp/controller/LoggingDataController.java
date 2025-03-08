package pl.project.plannerapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.project.plannerapp.DTO.LoggingDataDTO;
import pl.project.plannerapp.service.LoggingDataService;
import pl.project.plannerapp.utils.LoggingDataConventerUtils;

import java.util.List;

@RestController
@RequestMapping(path = "/api/loggingData", produces = MediaType.APPLICATION_JSON_VALUE)
public class LoggingDataController {
    private final LoggingDataService loggingDataService;


    @Autowired
    public LoggingDataController(LoggingDataService loggingDataService) {
        this.loggingDataService = loggingDataService;
    }

    @GetMapping
    public List<LoggingDataDTO> getAllLoggingDatas() {
        return loggingDataService.getAllLoginData().stream().map(a -> LoggingDataConventerUtils.convert(a)).toList();
    }

    @GetMapping("/{loggingDataId}")
    public LoggingDataDTO get(@PathVariable Long id) {
        return loggingDataService.getById(id).map(a -> LoggingDataConventerUtils.convert(a))
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
