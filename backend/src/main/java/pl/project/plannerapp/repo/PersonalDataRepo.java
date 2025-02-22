package pl.project.plannerapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.project.plannerapp.domain.PersonalDataEntity;

import java.util.Optional;

@Repository
public interface PersonalDataRepo extends JpaRepository<PersonalDataEntity, Long> {
    Optional<PersonalDataEntity> findById(Long id);
    Optional<PersonalDataEntity> findBySurname(String surname);

    //    Optional<PersonalDataEntity> findByPersonalDataByAccountDetailsId(long accountDetailsId);
    Optional<PersonalDataEntity> findByPersonalDataByLoggingDataId(long loggingDataId);
}
