package pl.project.plannerapp.service;

import pl.project.plannerapp.DTO.DietDTO;

import java.util.List;
import java.util.Optional;

public interface DietService {
    List<DietDTO> getAll();
    void put(Long id, DietDTO dietDTO);

    void delete(Long id);

    Optional<DietDTO> getById(Long id);
}
