package aicha.pfe.tasks.repository;

import aicha.pfe.tasks.entity.Leaves;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeavesRepository extends CrudRepository<Leaves, Long> {
}
