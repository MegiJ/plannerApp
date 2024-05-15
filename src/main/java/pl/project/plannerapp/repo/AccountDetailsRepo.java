package pl.project.plannerapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.project.plannerapp.repo.model.AccountDetails;

import java.util.Optional;

@Repository
public interface AccountDetailsRepo extends JpaRepository<AccountDetails, Long> {
    Optional<AccountDetails> findById(Long id);


}
