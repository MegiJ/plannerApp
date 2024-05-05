package pl.project.plannerapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.project.plannerapp.repo.PersonalDataRepo;
import pl.project.plannerapp.repo.TrainingRepo;

@Service
public class TrainingServiceImpl implements TrainingService {
    private final TrainingRepo trainingRepo;
    private final PersonalDataRepo personalDataRepo;

    @Autowired
    public TrainingServiceImpl(TrainingRepo trainingRepo, PersonalDataRepo personalDataRepo) {
        this.trainingRepo = trainingRepo;
        this.personalDataRepo = personalDataRepo;
    }
}
