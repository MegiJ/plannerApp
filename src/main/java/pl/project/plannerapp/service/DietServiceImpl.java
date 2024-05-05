package pl.project.plannerapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.project.plannerapp.DTO.DietDTO;
import pl.project.plannerapp.model.Diet;
import pl.project.plannerapp.repo.DietRepo;
import pl.project.plannerapp.repo.PersonalDataRepo;
import pl.project.plannerapp.utils.ConventerUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DietServiceImpl implements DietService {
    private final DietRepo dietRepo;
    private final PersonalDataRepo personalDataRepo;

    @Autowired
    public DietServiceImpl(DietRepo dietRepo, PersonalDataRepo personalDataRepo) {
        this.dietRepo = dietRepo;
        this.personalDataRepo = personalDataRepo;
    }

    @Override
    public List<DietDTO> getAll() {
        return dietRepo.findAll().stream()
                .map(ConventerUtils::convert)
                .collect(Collectors.toList());
    }

    @Override
    public void put(int id, DietDTO dietDTO) {

    }

    @Override
    public void delete(int id) {
        Diet diet = dietRepo.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        dietRepo.delete(diet);
    }

    @Override
    public Optional<DietDTO> getById(int id) {
        return dietRepo.findById(id).map(ConventerUtils::convert);
    }
}
