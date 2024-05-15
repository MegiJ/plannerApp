package pl.project.plannerapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.project.plannerapp.DTO.DietDTO;
import pl.project.plannerapp.model.Diet;
import pl.project.plannerapp.repo.DietRepo;
import pl.project.plannerapp.repo.PersonalDataRepo;
import pl.project.plannerapp.utils.DietConventerUtils;

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
        return dietRepo.findAll()
                .stream()
                .map(DietConventerUtils::convert)
                .collect(Collectors.toList());
    }

    @Override
    public void add(Diet diet) {
        dietRepo.save(diet);
    }

    @Override
    public void delete(Diet diet) {
        dietRepo.delete(diet);
    }

    @Override
    public Optional<DietDTO> getById(Long id) {
        return dietRepo.findById(id)
                .map(DietConventerUtils::convert);
    }
}
