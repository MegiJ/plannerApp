package pl.project.plannerapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DashboardRepo extends JpaRepository<Dashboard, Integer> {
    Optional<Dashboard> findById(int id);
}
