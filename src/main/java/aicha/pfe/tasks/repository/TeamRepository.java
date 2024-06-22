package aicha.pfe.tasks.repository;

import aicha.pfe.tasks.entity.Team;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends CrudRepository<Team, Long> {

   // @Query("SELECT t FROM Team t")
  //  List<Team> findAllTeams();
}
