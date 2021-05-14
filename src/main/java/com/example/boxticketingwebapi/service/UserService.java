package com.example.boxticketingwebapi.service;

import com.example.boxticketingwebapi.controller.exceptions.BadRequestException;
import com.example.boxticketingwebapi.dto.request.SignupRequestDTO;
import com.example.boxticketingwebapi.dto.response.JwtResponseDTO;
import com.example.boxticketingwebapi.dto.response.MessageResponseDTO;
import com.example.boxticketingwebapi.model.ERole;
import com.example.boxticketingwebapi.model.RoleModel;
import com.example.boxticketingwebapi.model.UserModel;
import com.example.boxticketingwebapi.repo.IRoleRepo;
import com.example.boxticketingwebapi.repo.IUserRepo;
import com.example.boxticketingwebapi.controller.exceptions.DataNotFoundException;
import com.example.boxticketingwebapi.security.jwt.JwtUtils;
import com.example.boxticketingwebapi.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class UserService {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    IRoleRepo roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    private IUserRepo userRepository;

    public JwtResponseDTO signIn(String userName, String pass){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userName, pass));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return new JwtResponseDTO(jwt, userDetails.getId(), userDetails.getUsername(), roles, userDetails.getAmountInWallet());
    }

    public void signUp(SignupRequestDTO signUpRequestDTO) {
        System.out.println("Here");
        if (userRepository.existsByUsername(signUpRequestDTO.getUsername())) {
            throw new BadRequestException("Username is already taken");
        }

        // Create new user's account
        UserModel user = new UserModel(signUpRequestDTO.getUsername(),
                encoder.encode(signUpRequestDTO.getPassword()),
                signUpRequestDTO.getAmountInWallet());

        Set<String> strRoles = signUpRequestDTO.getRole();
        Set<RoleModel> roles = new HashSet<>();

        if (strRoles == null) {
            RoleModel userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new DataNotFoundException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        RoleModel adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new DataNotFoundException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;
                    default:
                        RoleModel userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new DataNotFoundException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }
        user.setRoles(roles);
        userRepository.save(user);
    }

    public UserModel saveUser(UserModel user){
        return userRepository.save(user);
    }

    public UserModel getUserById(Long accountId){
        UserModel account = this.userRepository.findById(accountId).orElse(null);
        if(account == null) {
            throw new DataNotFoundException("Account with id:" + accountId + " doesn't exists!");
        }
        return account;
    }

}
