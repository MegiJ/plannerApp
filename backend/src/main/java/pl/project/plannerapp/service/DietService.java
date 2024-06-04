package pl.project.plannerapp.service;

import pl.project.plannerapp.DTO.DietDTO;
import pl.project.plannerapp.model.Diet;

import java.util.List;
import java.util.Optional;

public interface DietService {
    List<DietDTO> getAllDiet();
    Diet addDiet(Diet diet);
    boolean deleteDiet(Long id);
    Optional<DietDTO> getById(Long id);
}