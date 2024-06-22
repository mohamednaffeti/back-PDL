package aicha.pfe.tasks.repository;

import aicha.pfe.tasks.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.username = :username")
    User findByUsername(String username);

    @Query("SELECT u FROM User u WHERE u.email = :email")
    User findByEmail(String email);

    @Query("SELECT u FROM User u JOIN u.roles r WHERE r.role = 'MANAGER'")
    List<User> getAllManagers();

    @Query("SELECT u FROM User u WHERE u.id <> :id ")
    List<User> getAllUsersExceptCurrentUser(Long id);

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, noRollbackFor = RuntimeException.class)
    User save(User user);







    @Query("SELECT u from User u WHERE u.createdDate> :date")
    List<User> retrieveSubscribedUsers(Date date);

    @Query("SELECT u FROM User u WHERE u.firstName = :firstName")
    public User findByFirstName(String firstName);

    @Query("SELECT u FROM User u WHERE u.team.id = :id")
    public List<User> findByFUserByTeam(Long id);
}
