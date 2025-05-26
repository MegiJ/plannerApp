package pl.project.plannerapp.service;

import pl.project.plannerapp.model.Diet;

import java.util.List;
import java.util.Optional;

public interface DietService {
    List<Diet> getAllDiet();
    Diet addDiet(Diet diet);

    Diet modifyDiet(Long dietId, String newDiet);

    boolean deleteDiet(Long id);
    Optional<Diet> getById(Long id);
}
