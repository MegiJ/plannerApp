package pl.project.plannerapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.project.plannerapp.domain.DietEntity;
import pl.project.plannerapp.domain.LoggingDataEntity;
import pl.project.plannerapp.model.Diet;
import pl.project.plannerapp.repo.DietRepo;
import pl.project.plannerapp.repo.LoggingDataRepo;
import pl.project.plannerapp.utils.DietConventerUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DietServiceImpl implements DietService {
    private final DietRepo dietRepo;
    private final LoggingDataRepo loggingDataRepo;

    @Autowired
    public DietServiceImpl(DietRepo dietRepo, LoggingDataRepo loggingDataRepo) {
        this.dietRepo = dietRepo;
        this.loggingDataRepo = loggingDataRepo;
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
    public Diet addDiet(Diet dietToBeAdded) {
        LoggingDataEntity loggingDataEntity = loggingDataRepo.findById(dietToBeAdded.getLoggingDataId()).get();
        DietEntity savedNewDietEntity = dietRepo.save(DietConventerUtils.convertToEntity(dietToBeAdded, loggingDataEntity));
        Diet dietWithId = DietConventerUtils.convert(savedNewDietEntity);
        return dietWithId;
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
