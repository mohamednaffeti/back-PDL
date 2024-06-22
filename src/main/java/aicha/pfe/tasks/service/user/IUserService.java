package aicha.pfe.tasks.service.user;

import aicha.pfe.tasks.entity.User;
import aicha.pfe.tasks.service.IService;

import java.util.List;

public interface IUserService extends IService<User> {



    User findUserByUsername(String username);



    User retrieveUser(Long id);





    User saveUser(User user);

     User findUserByFirstName(String firstName);

    List<User> getAllManagers();

    List<User> getAllUsersExceptCurrentUser(Long id);

}
