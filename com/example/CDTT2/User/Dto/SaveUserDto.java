package com.example.CDTT2.User.Dto;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveUserDto {
	
	private Long id;
	
	private String email;

	private String phone;

	private String username;

	private String password;
	
	private String confirmPassword;

	private String fbUserId;
	
	private Set<Long> idRole=new HashSet<>();
}
