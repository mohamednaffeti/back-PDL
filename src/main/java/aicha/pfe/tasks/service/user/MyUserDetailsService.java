package aicha.pfe.tasks.service.user;

import aicha.pfe.tasks.entity.Role;
import aicha.pfe.tasks.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MyUserDetailsService implements UserDetailsService {

	private final UserServiceImpl userService;

	@Autowired
	public MyUserDetailsService(UserServiceImpl userService) {
		this.userService = userService;
	}



	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.findUserByUsername(username);

		List<GrantedAuthority> authorities = getUserAuthority(user.getRoles());
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				user.getActive(), true, true, true, authorities);
	}

	private List<GrantedAuthority> getUserAuthority(Set<Role> userRoles) {
		Set<GrantedAuthority> roles = new HashSet<>();
		for (Role role : userRoles) {
			roles.add(new SimpleGrantedAuthority(role.getRole().name()));
		}
		return new ArrayList<>(roles);
	}

}
