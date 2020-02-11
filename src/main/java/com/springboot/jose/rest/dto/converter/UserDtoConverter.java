package com.springboot.jose.rest.dto.converter;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.springboot.jose.rest.dto.GetUserDto;
import com.springboot.jose.rest.model.UserEntity;
import com.springboot.jose.rest.model.UserRole;



@Component
public class UserDtoConverter {
	
	public GetUserDto convertUserEntityToGetUserDto(UserEntity user) {
		return GetUserDto.builder()
				.username(user.getUsername())
				.avatar(user.getAvatar())
				.fullName(user.getFullName())
				.email(user.getEmail())
				.roles(user.getRoles().stream()
							.map(UserRole::name)
							.collect(Collectors.toSet())
				).build();
	}

}
