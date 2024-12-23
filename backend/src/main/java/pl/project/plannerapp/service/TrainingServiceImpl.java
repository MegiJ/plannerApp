package pl.project.plannerapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.project.plannerapp.domain.AccountDetailsEntity;
import pl.project.plannerapp.domain.TrainingEntity;
import pl.project.plannerapp.model.Training;
import pl.project.plannerapp.repo.AccountDetailsRepo;
import pl.project.plannerapp.repo.PersonalDataRepo;
import pl.project.plannerapp.repo.TrainingRepo;
import pl.project.plannerapp.utils.TrainingConventerUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TrainingServiceImpl implements TrainingService {
    private final TrainingRepo trainingRepo;
    private final PersonalDataRepo personalDataRepo;
    private final AccountDetailsRepo accountDetailsRepo;

    @Autowired
    public TrainingServiceImpl(TrainingRepo trainingRepo, PersonalDataRepo personalDataRepo, AccountDetailsRepo accountDetailsRepo) {
        this.trainingRepo = trainingRepo;
        this.personalDataRepo = personalDataRepo;
        this.accountDetailsRepo = accountDetailsRepo;
    }

    @Override
    public List<Training> getAllTraining() {
        return trainingRepo.findAll()
                .stream()
                .map(TrainingConventerUtils::convert)
                .collect(Collectors.toList());

    }

    @Override
    public Training addExercise(Training training) {
        AccountDetailsEntity accountDetailsEntity = accountDetailsRepo.findById(training.getPersonalData().getPersonalDataId()).get();
        trainingRepo.save(TrainingConventerUtils.convertToEntity(training, accountDetailsEntity));
        return training;
    }
    @Override
    public boolean deleteExercise(Long id) {
        TrainingEntity trainingEntity = trainingRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        trainingRepo.delete(trainingEntity);
        return true;
    }

    @Override
    public Optional<Training> getById(Long id) {
        return trainingRepo.findById(id)
                .map(TrainingConventerUtils::convert);
    }
}
