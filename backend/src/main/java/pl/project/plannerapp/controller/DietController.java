package pl.project.plannerapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.project.plannerapp.DTO.DietDTORequest;
import pl.project.plannerapp.DTO.DietDTOResponse;
import pl.project.plannerapp.model.Diet;
import pl.project.plannerapp.service.DietService;
import pl.project.plannerapp.utils.DietConventerUtils;

import java.util.List;
import java.util.Optional;

@Validated
@RestController
@RequestMapping(path = "/api/diets", produces = MediaType.APPLICATION_JSON_VALUE)
public class DietController {
    private final DietService dietService;

    @Autowired
    public DietController(DietService dietService) {
        this.dietService = dietService;
    }

    @GetMapping
    public List<DietDTOResponse> getAllDiets() {
        return dietService.getAllDiet().stream()
                .map(DietConventerUtils::convert)
                .toList();
    }

    @GetMapping("/{dietId}")
    public ResponseEntity<DietDTOResponse> getDietById(@PathVariable Long dietId) {
        Optional<DietDTOResponse> dietDTOResponse = dietService.getById(dietId)
                .map(DietConventerUtils::convert);
        return dietDTOResponse.map(dietDTO -> new ResponseEntity<>(dietDTO, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public Long addDiet(@RequestBody DietDTORequest dietJson) {
        Diet dietWithId = dietService.addDiet(DietConventerUtils.convert(dietJson));
        return dietWithId.getDietId();
    }

    @PutMapping("/{dietId}/diet")
    public ResponseEntity<DietDTOResponse> modifyDiet(@PathVariable Long dietId, @RequestBody String newDiet) {
        Diet findDiet = dietService.modifyDiet(dietId, newDiet);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Transactional
    @DeleteMapping("/{dietId}")
    public void delete(@PathVariable Long dietId) {
    }
}
