package pl.project.plannerapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.project.plannerapp.DTO.TrainingDTO;
import pl.project.plannerapp.model.Training;
import pl.project.plannerapp.repo.PersonalDataRepo;
import pl.project.plannerapp.repo.TrainingRepo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TrainingServiceImpl implements TrainingService {
    private final TrainingRepo trainingRepo;
    private final PersonalDataRepo personalDataRepo;

    @Autowired
    public TrainingServiceImpl(TrainingRepo trainingRepo, PersonalDataRepo personalDataRepo) {
        this.trainingRepo = trainingRepo;
        this.personalDataRepo = personalDataRepo;
    }

    @Override
    public List<TrainingDTO> getAll() {
        return trainingRepo.findAll();

    }

    @Override
    public void put(Long id, TrainingDTO trainingDTO) {

    }

    @Override
    public void delete(Long id) {
        Training training = trainingRepo.findById(id)
    }

    @Override
    public Optional<TrainingDTO> getById(Long id) {
        return Optional.empty();
    }
}
