package aicha.pfe.tasks.service.user;

import aicha.pfe.tasks.entity.Role;
import aicha.pfe.tasks.entity.User;
import aicha.pfe.tasks.repository.RoleRepository;
import aicha.pfe.tasks.repository.UserRepository;
import aicha.pfe.tasks.entity.RoleName;

import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

@Service
@Slf4j
public class UserServiceImpl implements IUserService {



    private final UserRepository userRepository;



    final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    private final RoleRepository roleRepository;


    @Autowired
    public UserServiceImpl(UserRepository userRepository,RoleRepository roleRepository) {
        this.userRepository = userRepository;

        this.roleRepository = roleRepository;
    }

    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(true);
        Role defaultRole = roleRepository.findByRole(RoleName.EMPLOYEE)
                .orElseThrow(() -> new RuntimeException("Default role not found."));
        user.setRoles(new HashSet<>(Collections.singletonList(defaultRole)));


        return userRepository.save(user);
    }


    @Override
    public User retrieveUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }
















    @Override
    public List<User> retrieve() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User add(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User update(User user) {
        userRepository.save(user);
        return user;
    }


     public User findUserByFirstName(String firstName){
        return userRepository.findByFirstName(firstName);
    }

    @Override
    public List<User> getAllManagers() {
        return userRepository.getAllManagers();
    }

    @Override
    public List<User> getAllUsersExceptCurrentUser(Long id) {
        return userRepository.getAllUsersExceptCurrentUser(id);
    }


}
