package aicha.pfe.tasks.repository;

import aicha.pfe.tasks.entity.Education;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends CrudRepository<Education, Long> {
}
