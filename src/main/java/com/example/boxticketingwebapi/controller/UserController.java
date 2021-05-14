package com.example.boxticketingwebapi.controller;

import com.example.boxticketingwebapi.dto.LoginRequestDTO;
import com.example.boxticketingwebapi.dto.MessageResponseDTO;
import com.example.boxticketingwebapi.dto.SignupRequestDTO;
import com.example.boxticketingwebapi.dto.JwtResponseDTO;
import com.example.boxticketingwebapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/ticket-api/v1/users")
public class UserController {
	@Autowired
	UserService userService;

	@PostMapping("/signin")
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody JwtResponseDTO authenticateUser(@Valid @RequestBody LoginRequestDTO loginRequestDTO) {
		JwtResponseDTO resp = userService.signIn(loginRequestDTO.getUsername(), loginRequestDTO.getPassword());
		return resp;
	}

	@PostMapping("/signup")
	@ResponseStatus(HttpStatus.CREATED)
	public MessageResponseDTO registerUser(@Valid @RequestBody SignupRequestDTO signUpRequestDTO) {
		userService.signUp(signUpRequestDTO);
		MessageResponseDTO message =  new MessageResponseDTO("Account successfully created.");
		message.add(linkTo(methodOn(this.getClass()).authenticateUser(new LoginRequestDTO())).withRel("signIn"));
		return message;
	}
}
