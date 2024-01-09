package com.example.project.User;

import org.springframework.stereotype.Service;

import com.example.project.DataTransfer.UserDto;

@Service
public class UserService {

	public UserDto convertToDto(User user) {
		UserDto dto = new UserDto();
		dto.setEmail(user.getEmail());
		dto.setFirst_name(user.getFirst_name());
		dto.setLast_name(user.getLast_name());
		dto.setRole(user.getRole());
		return dto;
	}
	
}
