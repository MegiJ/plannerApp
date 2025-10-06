package pl.project.plannerapp.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import pl.project.plannerapp.domain.DietEntity;
import pl.project.plannerapp.domain.LoggingDataEntity;
import pl.project.plannerapp.exceptions.DietException;
import pl.project.plannerapp.model.Diet;
import pl.project.plannerapp.repo.DietRepo;
import pl.project.plannerapp.repo.LoggingDataRepo;
import pl.project.plannerapp.utils.DietConventerUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
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

    @Override
    public Diet modifyDiet(Long dietId, String newDiet) {
        Optional<DietEntity> dietEntityOptional = dietRepo.findById(dietId);
        if (dietEntityOptional.isEmpty()) {
            log.warn("Diet " + dietId + " not found");
            throw new DietException("Diet not found");
        }
        DietEntity currentDiet = dietEntityOptional.get();
        currentDiet.setMeal(newDiet);
        DietEntity dietEntity = dietRepo.save(currentDiet);
        return DietConventerUtils.convert(dietEntity);
    }

    public void deleteDiet(Long id) {
        DietEntity dietEntity = dietRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        dietRepo.delete(dietEntity);
    }

    @Override
    public Optional<Diet> getById(Long id) {
        return dietRepo.findById(id)
                .map(DietConventerUtils::convert);
    }
}
