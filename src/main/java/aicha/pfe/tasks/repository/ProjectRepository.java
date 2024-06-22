package aicha.pfe.tasks.repository;

import aicha.pfe.tasks.entity.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

    @Query("SELECT p FROM Project p WHERE p.name = :name")
    Project findProjectByName(@Param("name") String name);

    @Query("SELECT p FROM Project p WHERE p.team.id = :id")
    public Project getProjectByTeam(Long id);
}
