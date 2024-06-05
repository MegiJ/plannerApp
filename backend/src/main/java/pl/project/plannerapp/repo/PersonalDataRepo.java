package pl.project.plannerapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.project.plannerapp.domain.PersonalDataEntity;
import pl.project.plannerapp.model.PersonalData;

import java.util.Optional;

@Repository
public interface PersonalDataRepo extends JpaRepository<PersonalDataEntity, Long> {
    Optional<PersonalDataEntity> findById(Long id);
}
