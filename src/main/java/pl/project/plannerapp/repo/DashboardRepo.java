package pl.project.plannerapp.repo;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.project.plannerapp.model.Dashboard;

import java.util.Optional;

@Repository
public interface DashboardRepo extends JpaRepository<Dashboard, Integer> {
    Optional<Dashboard> findById(int id);
}
