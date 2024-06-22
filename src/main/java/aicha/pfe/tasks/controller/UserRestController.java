package aicha.pfe.tasks.controller;

import aicha.pfe.tasks.entity.Role;
import aicha.pfe.tasks.entity.Team;
import aicha.pfe.tasks.entity.User;
import aicha.pfe.tasks.repository.RoleRepository;
import aicha.pfe.tasks.repository.TeamRepository;
import aicha.pfe.tasks.repository.UserRepository;
import aicha.pfe.tasks.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.servlet.ModelAndView;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserRestController {

    private final IUserService userService;

    private final UserRepository userRepository;



    private final RoleRepository roleRepository;

    private final TeamRepository teamRepository;

    final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    @Autowired
    public UserRestController(IUserService userService, UserRepository userRepository,  RoleRepository roleRepository, TeamRepository teamRepository) {
        this.userService = userService;
        this.userRepository = userRepository;

        this.roleRepository = roleRepository;
        this.teamRepository = teamRepository;
    }


    @GetMapping("/retrieve-all-users")
    @ResponseBody
    public List<User> getUsers() {
        return userService.retrieve();
    }

    @PostMapping("/add-user")
    @ResponseBody
    public User addUser(@RequestBody User user) {
        Set<Role> roles = new HashSet<>();
        for (Role r : user.getRoles()) {
            Role role = roleRepository.findById(r.getId()).orElseThrow(() -> new EntityNotFoundException("Role does not exist"));
            roles.add(role);
        }
        user.getRoles().clear();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(true);
        user.getRoles().addAll(roles);
        return userService.add(user);
    }

    @DeleteMapping("/remove-user/{user-id}")
    @ResponseBody
    public void removeUser(@PathVariable("user-id") Long userId) {
        userService.delete(userId);
    }

    @PatchMapping("/modify-user")
    @ResponseBody
    public User modifyUser(@RequestBody User user) {
        return userService.update(user);
    }


    @PostMapping("/registration")
    public User createNewUser(@RequestBody User user)
            {


        if (userService.findUserByUsername(user.getUsername()) != null) {
           return null ;

        } else {
            return userService.saveUser(user);
        }

    }


    private String getSiteURL(HttpServletRequest request) {
        String siteURL = request.getRequestURL().toString();
        return siteURL.replace(request.getServletPath(), "");
    }




    @GetMapping("/find-userByFirstname/{user-firstName}")
    @ResponseBody
    public void findUserByFirstName(@PathVariable("user-firstName") String firstName) {
        userService.findUserByFirstName(firstName);
    }

    @GetMapping("/retrieve-user/{user-id}")
    @ResponseBody
    public User retrieveUser(@PathVariable("user-id") Long id) {
        return userService.retrieveUser(id);
    }

    @GetMapping("/retrieve-all-managers")
    @ResponseBody
    public List<User> getAllManagers() {
        return userService.getAllManagers();
    }

    @GetMapping("/retrieve-all-users-except-current/{user-id}")
    @ResponseBody
    public List<User> getAllUsersExceptCurrentUser(@PathVariable("user-id") Long id) {
        return userService.getAllUsersExceptCurrentUser(id);
    }

    @GetMapping("/get-all-users-by-team/{team-id}")
    @ResponseBody
    public List<User> getAllUsersByTeam(@PathVariable("team-id") Long id) {
        List<User> users = userRepository.findByFUserByTeam(id);
        return users;
    }

    @GetMapping("/affect-team-to-user/{team-id}/{user-id}/{status}")
    @ResponseBody
    public User affectTeamToUser(@PathVariable("team-id") Long teamId , @PathVariable("user-id") Long userId , @PathVariable("status") String status) {
        User user = userRepository.findById(userId).orElse(null);
        Team team = teamRepository.findById(teamId).orElse(null);
       if("affect".equals(status)){
           user.setTeam(team);
       }else if("delete".equals(status)){
           user.setTeam(null);
       }
        return userRepository.save(user);
    }
}


