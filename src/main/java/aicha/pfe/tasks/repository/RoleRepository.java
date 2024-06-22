package aicha.pfe.tasks.repository;

import aicha.pfe.tasks.entity.Role;
import aicha.pfe.tasks.entity.RoleName;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

    @Query("SELECT r FROM Role r WHERE r.role = :role")
    Optional<Role> findByRole(RoleName role);

}
