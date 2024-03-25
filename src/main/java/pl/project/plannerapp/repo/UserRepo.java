package pl.project.plannerapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.project.plannerapp.model.AccountDetails;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<AccountDetails, Long> {
    Optional<AccountDetails> findById(Long id);
}
