package pl.project.plannerapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import pl.project.plannerapp.DTO.PersonalDataDTO;
import pl.project.plannerapp.service.PersonalDataService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/personalData", produces = MediaType.APPLICATION_JSON_VALUE)
public class PersonalDataController {

    private  final PersonalDataService personalDataService;

    @Autowired
    public PersonalDataController(PersonalDataService personalDataService) {
        this.personalDataService = personalDataService;
    }

    @GetMapping
    public List<PersonalDataDTO> get() {
        return null;
    }

    @GetMapping("/{personalData-id}")
    public PersonalDataDTO get(@PathVariable Long id) {
        return null;
    }

    @Transactional
    @PutMapping("/personalData-id")
    public void put(@PathVariable Long id, @RequestBody PersonalDataDTO personalDataJson) {

    }

    @Transactional
    @DeleteMapping("/{personalData-id}")
    public void delete(@PathVariable Long id) {

    }
}
