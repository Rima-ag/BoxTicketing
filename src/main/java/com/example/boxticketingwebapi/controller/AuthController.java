package com.example.boxticketingwebapi.controller;

import com.example.boxticketingwebapi.dto.request.LoginRequestDTO;
import com.example.boxticketingwebapi.dto.request.SignupRequestDTO;
import com.example.boxticketingwebapi.dto.response.JwtResponseDTO;
import com.example.boxticketingwebapi.dto.response.MessageResponseDTO;
import com.example.boxticketingwebapi.model.ERole;
import com.example.boxticketingwebapi.model.RoleModel;
import com.example.boxticketingwebapi.model.UserModel;
import com.example.boxticketingwebapi.repo.IRoleRepo;
import com.example.boxticketingwebapi.repo.IUserRepo;
import com.example.boxticketingwebapi.security.jwt.JwtUtils;
import com.example.boxticketingwebapi.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/ticket-api/v1/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	IUserRepo userRepository;

	@Autowired
	IRoleRepo roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequestDTO loginRequestDTO) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequestDTO.getUsername(), loginRequestDTO.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponseDTO(jwt,
												 userDetails.getId(), 
												 userDetails.getUsername(),
												 roles));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequestDTO signUpRequestDTO) {
		if (userRepository.existsByUsername(signUpRequestDTO.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponseDTO("Error: Username is already taken!"));
		}


		// Create new user's account
		UserModel user = new UserModel(signUpRequestDTO.getUsername(),
							 encoder.encode(signUpRequestDTO.getPassword()));

		Set<String> strRoles = signUpRequestDTO.getRole();
		Set<RoleModel> roles = new HashSet<>();

		if (strRoles == null) {
			RoleModel userRole = roleRepository.findByName(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					RoleModel adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);

					break;
				default:
					RoleModel userRole = roleRepository.findByName(ERole.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
				}
			});
		}

		user.setRoles(roles);
		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponseDTO("User registered successfully!"));
	}
}
