package pl.project.plannerapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.project.plannerapp.model.PersonalData;

import java.util.Optional;

@Repository
public interface PersonalDataRepo extends JpaRepository<PersonalData, Long> {
    @Override
    Optional<PersonalData> findById(Long id);
}
