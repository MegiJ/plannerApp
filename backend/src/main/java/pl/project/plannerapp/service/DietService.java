package pl.project.plannerapp.service;

import pl.project.plannerapp.model.Diet;

import java.util.List;
import java.util.Optional;

public interface DietService {
    List<Diet> getAllDiet();
    Diet addDiet(Diet diet);
    boolean deleteDiet(Long id);
    Optional<Diet> getById(Long id);
}
