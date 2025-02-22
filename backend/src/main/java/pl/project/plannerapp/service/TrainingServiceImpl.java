package pl.project.plannerapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.project.plannerapp.domain.LoggingDataEntity;
import pl.project.plannerapp.domain.TrainingEntity;
import pl.project.plannerapp.model.Training;
import pl.project.plannerapp.repo.AccountDetailsRepo;
import pl.project.plannerapp.repo.LoggingDataRepo;
import pl.project.plannerapp.repo.PersonalDataRepo;
import pl.project.plannerapp.repo.TrainingRepo;
import pl.project.plannerapp.utils.TrainingConventerUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TrainingServiceImpl implements TrainingService {
    private final TrainingRepo trainingRepo;
    private final LoggingDataRepo loggingDataRepo;

    @Autowired
    public TrainingServiceImpl(TrainingRepo trainingRepo, PersonalDataRepo personalDataRepo, AccountDetailsRepo accountDetailsRepo, LoggingDataRepo loggingDataRepo) {
        this.trainingRepo = trainingRepo;
        this.loggingDataRepo = loggingDataRepo;
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
        LoggingDataEntity loggingDataEntity = loggingDataRepo.findById(training.getLoggingData().getId()).get();
        TrainingEntity trainingEntity = TrainingConventerUtils.convertToEntity(training);
        TrainingEntity savedNewTraining = trainingRepo.save(trainingEntity);
        Training trainingWithId = TrainingConventerUtils.convert(savedNewTraining);
        return trainingWithId;
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
