package com.example.boxticketingwebapi.controller;

import com.example.boxticketingwebapi.dto.request.LoginRequestDTO;
import com.example.boxticketingwebapi.dto.request.SignupRequestDTO;
import com.example.boxticketingwebapi.dto.response.JwtResponseDTO;
import com.example.boxticketingwebapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/ticket-api/v1/users")
public class UserController {
	@Autowired
	UserService userService;

	@PostMapping("/signin")
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody JwtResponseDTO authenticateUser(@Valid @RequestBody LoginRequestDTO loginRequestDTO) {
		JwtResponseDTO resp = this.userService.signIn(loginRequestDTO.getUsername(), loginRequestDTO.getPassword());
		return resp;
	}

	@PostMapping("/signup")
	@ResponseStatus(HttpStatus.OK)
	public void registerUser(@Valid @RequestBody SignupRequestDTO signUpRequestDTO) {
		this.userService.signUp(signUpRequestDTO);
	}
}
