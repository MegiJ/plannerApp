package pl.project.plannerapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.project.plannerapp.domain.AccountDetailsEntity;
import pl.project.plannerapp.model.AccountDetails;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountDetailsRepo extends JpaRepository<AccountDetailsEntity, Long> {
    Optional<AccountDetailsEntity> findById(Long id);

    @Query(nativeQuery = true, value = "select * from account_details where IS_EXPIRED is true")
    List<AccountDetailsEntity> findAllExpiredAccount();
}
