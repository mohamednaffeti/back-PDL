package aicha.pfe.tasks.controller;

import aicha.pfe.tasks.entity.JwtResponse;
import aicha.pfe.tasks.entity.LoginRequest;
import aicha.pfe.tasks.entity.User;
import aicha.pfe.tasks.security.JwtUtils;
import aicha.pfe.tasks.service.user.IUserService;
import aicha.pfe.tasks.service.user.MyUserDetailsService;
import aicha.pfe.tasks.service.user.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@CrossOrigin(origins = "*")
public class JwtAuthenticationController {

	private final AuthenticationManager authenticationManager;



	private final MyUserDetailsService userDetailsService;

	private final IUserService userService;

	@Autowired
	JwtUtils jwtUtils;

	@Autowired
	public JwtAuthenticationController(AuthenticationManager authenticationManager,  MyUserDetailsService userDetailsService, IUserService userService) {
		this.authenticationManager = authenticationManager;
		this.userDetailsService = userDetailsService;
		this.userService = userService;
	}

	@PostMapping("/authenticate")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
						loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt,
				userDetails.getId(),
				userDetails.getUsername(),
				userDetails.getEmail(),
				roles));
	}

	//@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
//	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
	//	authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
	//	final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
	//	final String token = jwtTokenUtil.generateToken(userDetails);
	//	User user = userService.findUserByUsername(authenticationRequest.getUsername());
	//	JSONObject response = new JSONObject();
	//	response.put("id", user.getId());
	//	response.put("token", new JwtResponse(token).getToken());
     //   response.put("roles", userDetails.getAuthorities());
     //   return ResponseEntity.ok(response.toString());
	//}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			User user = userService.findUserByUsername(username);


			throw new Exception(
					"Your account has been locked due to 3 failed attempts." + " It will be unlocked after 24 hours.");
		} catch (BadCredentialsException e) {
			User user = userService.findUserByUsername(username);


			throw new Exception("INVALID_CREDENTIALS", e);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
