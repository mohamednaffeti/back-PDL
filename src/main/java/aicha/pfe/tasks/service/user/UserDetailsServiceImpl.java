package aicha.pfe.tasks.service.user;

import aicha.pfe.tasks.entity.User;
import aicha.pfe.tasks.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



//la classe UserDetailsServiceImpl implémente UserDetailsService pour obtenir l'objet UserDetails
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    //l'utilisation de UserRepository nous permet d'obtenir l'objet User
    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        return UserDetailsImpl.build(user);
    }
}
