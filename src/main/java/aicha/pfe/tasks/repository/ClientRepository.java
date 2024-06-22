package aicha.pfe.tasks.repository;

import aicha.pfe.tasks.entity.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {

    @Query("SELECT c FROM Client c WHERE c.name = :name")
    Client findClientByName(@Param("name") String name);
}
