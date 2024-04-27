package pl.project.plannerapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.project.plannerapp.DTO.DietDTO;
import pl.project.plannerapp.repo.DietRepo;
import pl.project.plannerapp.repo.PersonalDataRepo;

import java.util.List;
import java.util.Optional;

@Service
public class DietImpl implements DietService {
    private final DietRepo dietRepo;
    private final PersonalDataRepo personalDataRepo;

    @Autowired
    public DietImpl(DietRepo dietRepo, PersonalDataRepo personalDataRepo) {
        this.dietRepo = dietRepo;
        this.personalDataRepo = personalDataRepo;
    }

    @Override
    public List<DietDTO> getAll() {
        return null;
    }

    @Override
    public void put(int id, DietDTO dietDTO) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Optional<DietDTO> getById(int id) {
        return Optional.empty();
    }
}
