package pl.project.plannerapp.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.project.plannerapp.DTO.PersonalDataDTO;
import pl.project.plannerapp.model.PersonalData;
import pl.project.plannerapp.service.PersonalDataService;
import pl.project.plannerapp.utils.PersonalDataConventerUtils;

import java.util.List;

@Slf4j
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
        return personalDataService.getAllPersonalData().stream()
                .map(pd -> PersonalDataConventerUtils.convert(pd))
                .toList();
    }

    @GetMapping("/{personalDataId}")
    public PersonalDataDTO getPersonalDataById(@PathVariable Long personalDataId) {
        return personalDataService.getById(personalDataId)
                .map(pd -> PersonalDataConventerUtils.convert(pd))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/bySurname")
    public ResponseEntity<?> getPersonalDataBySurname(@RequestParam String surname) {
        List<PersonalData> personsWithSurname = personalDataService.getBySurname(surname);
        if (personsWithSurname.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nie znaleziono nazwiska: " + surname);
        } else {
            return ResponseEntity.ok(personsWithSurname);
        }
    }

    @PostMapping
    public long createPersonalData(@RequestBody PersonalDataDTO personalDataJson) {
        PersonalData personalDataWithId = personalDataService.addPersonalData(PersonalDataConventerUtils.convert(personalDataJson));
        return personalDataWithId.getPersonalDataId();
    }

    @PutMapping("/{personalDataId}/surname")
    public ResponseEntity<?> updateSurname(@PathVariable Long personalDataId, @RequestBody String newSurname) {
        PersonalData findSurname = personalDataService.modifySurname(personalDataId, newSurname);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // tym dodajesz status kodu bledu albo inf 200 lub 204 itp
    }

    @PutMapping("/{personalDataId}/firstname")
    public ResponseEntity<?> updateFirstname(@PathVariable Long personalDataId, @RequestBody String newFirstname) {
        PersonalData findFirstname = personalDataService.modifyFirstname(personalDataId, newFirstname);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // tym dodajesz status kodu bledu albo inf 200 lub 204 itp
    }

    @PutMapping("/{personalDataId}/phone")
    public ResponseEntity<?> updatePhone(@PathVariable Long personalDataId, @RequestBody int newPhone) {
        PersonalData findPhone = personalDataService.modifyPhone(personalDataId, newPhone);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // tym dodajesz status kodu bledu albo inf 200 lub 204 itp
    }

    @PutMapping("/{personalDataId}/email")
    public ResponseEntity<?> updateEmail(@PathVariable Long personalDataId, @RequestBody String newEmail) {
        PersonalData findEmail = personalDataService.modifyEmail(personalDataId, newEmail);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // tym dodajesz status kodu bledu albo inf 200 lub 204 itp
    }

    @Transactional
    @DeleteMapping("/{personalDataId}")
    public void delete(@PathVariable Long personalDataId) {
        personalDataService.delete(personalDataId);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(
        Exception exception, HttpServletRequest httpServletRequest
    ) {
        log.warn(
                "Something bad. Exception: {}, error message: {}",
                httpServletRequest.getRequestURI(),
                exception.getMessage()
        );
        return new ResponseEntity<>("Something bad", HttpStatus.BAD_REQUEST);
    }
}
