package pl.project.plannerapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.project.plannerapp.DTO.PersonalDataDTO;
import pl.project.plannerapp.model.PersonalData;
import pl.project.plannerapp.service.PersonalDataService;
import pl.project.plannerapp.utils.PersonalDataConventerUtils;

import java.util.List;
import java.util.Optional;

@Validated
@RestController
@RequestMapping(path = "/api/personalData", produces = MediaType.APPLICATION_JSON_VALUE)
public class PersonalDataController {

    private final PersonalDataService personalDataService;

    @Autowired
    public PersonalDataController(PersonalDataService personalDataService) {
        this.personalDataService = personalDataService;
    }

    @GetMapping
    public List<PersonalDataDTO> getAllPersonalDatas() {
        return personalDataService.getAllPersonalData().stream().map(a -> PersonalDataConventerUtils.convert(a)).toList();
    }

    @GetMapping("/{personalDataId}")
    public PersonalDataDTO getPersonalDataById(@PathVariable Long personalDataId) {
        return personalDataService.getById(personalDataId).map(a -> PersonalDataConventerUtils.convert(a))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/bySurname")
    public ResponseEntity<List<PersonalData>> getPersonalDataBySurname(@RequestParam String surname) {
        List<PersonalData> persons = personalDataService.getBySurname(surname);
        if (persons.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(persons);
    }

    @PostMapping
    public long createPersonalData(@RequestBody PersonalDataDTO personalDataJson) {
        PersonalData personalDataWithId = personalDataService.addPersonalData(PersonalDataConventerUtils.convert(personalDataJson));
        return personalDataWithId.getPersonalDataId();
    }

    @Transactional
    @PutMapping("/{personalDataId}/surname")
    public ResponseEntity<PersonalData> updateSurname(@PathVariable Long id, @RequestBody String newSurname) {
        Optional<PersonalData> personalDataOptional = personalDataService.getById(id);
        if (!personalDataOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        PersonalData personalData1 = personalDataOptional.get();
        personalData1.setSurname(newSurname);
        // personalDataService.save(personalData1);

        return ResponseEntity.ok(personalData1);
    }

    @Transactional
    @DeleteMapping("/{personalDataId}")
    public void delete(@PathVariable Long id) {

    }
}
