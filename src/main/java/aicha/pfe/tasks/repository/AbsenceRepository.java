package aicha.pfe.tasks.repository;

import aicha.pfe.tasks.entity.Absence;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbsenceRepository extends CrudRepository<Absence, Long> {

}
