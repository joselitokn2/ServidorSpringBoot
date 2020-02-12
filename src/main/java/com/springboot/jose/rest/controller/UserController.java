package com.springboot.jose.rest.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.jose.rest.dto.CreateUserDto;
import com.springboot.jose.rest.dto.GetUserDto;
import com.springboot.jose.rest.dto.converter.UserDtoConverter;
import com.springboot.jose.rest.model.UserEntity;
import com.springboot.jose.rest.service.UserEntityService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController { 
	
	private final UserEntityService userEntityService;
	private final UserDtoConverter userDtoConverter;
	
	
	@PostMapping("/")
	public GetUserDto nuevoUsuario(@RequestBody CreateUserDto newUser) {
			return userDtoConverter.convertUserEntityToGetUserDto(userEntityService.nuevoUsuario(newUser));

	}
	
	
	@GetMapping("/me")
	public GetUserDto yo(@AuthenticationPrincipal UserEntity user) {
		return userDtoConverter.convertUserEntityToGetUserDto(user);
	}

}
