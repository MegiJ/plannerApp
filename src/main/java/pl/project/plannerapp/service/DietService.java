package pl.project.plannerapp.service;

import org.hibernate.validator.constraints.NotEmpty;
import pl.project.plannerapp.DTO.DietDTO;

import java.util.List;
import java.util.Optional;

public interface DietService {
    List<DietDTO> getAll();
    void put(int id, DietDTO dietDTO);
    void delete(int id);
    Optional<DietDTO> getById(int id);
}
