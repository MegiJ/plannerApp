package pl.project.plannerapp.service;

import pl.project.plannerapp.DTO.DietDTO;
import pl.project.plannerapp.repo.model.Diet;

import java.util.List;
import java.util.Optional;

public interface DietService {
    List<DietDTO> getAll();
    void add(Diet diet);

    void delete(Diet diet);

    Optional<DietDTO> getById(Long id);
}
