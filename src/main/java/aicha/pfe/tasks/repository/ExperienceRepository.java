package aicha.pfe.tasks.repository;

import aicha.pfe.tasks.entity.Experience;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepository extends CrudRepository<Experience, Long> {
}
