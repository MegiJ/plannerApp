package pl.project.plannerapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.project.plannerapp.domain.AccountDetailsEntity;
import pl.project.plannerapp.model.Diet;
import pl.project.plannerapp.repo.AccountDetailsRepo;
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
    private final AccountDetailsRepo accountDetailsRepo;

    @Autowired
    public DietServiceImpl(DietRepo dietRepo, PersonalDataRepo personalDataRepo, AccountDetailsRepo accountDetailsRepo) {
        this.dietRepo = dietRepo;
        this.personalDataRepo = personalDataRepo;
        this.accountDetailsRepo = accountDetailsRepo;
    }

    @Override
    public List<Diet> getAllDiet() {
        return dietRepo.findAll()
                .stream()
                .map(DietConventerUtils::convert)
                .collect(Collectors.toList());
    }
    @Transactional
    @Override
    public Diet addDiet(Diet diet) {
        AccountDetailsEntity accountDetailsEntity = accountDetailsRepo.findById(diet.getPersonalData().getPersonalDataId()).get();
        dietRepo.save(DietConventerUtils.convertToEntity(diet, accountDetailsEntity));
        return diet;
    }

    public boolean deleteDiet(Long id) {
        return false;
    }

    @Override
    public Optional<Diet> getById(Long id) {
        return dietRepo.findById(id)
                .map(DietConventerUtils::convert);
    }
}
