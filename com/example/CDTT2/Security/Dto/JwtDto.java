package com.example.CDTT2.Security.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtDto {
		
		private String dto;
		
		public JwtDto gẹtwtDto(String token)
		{
			this.dto=token;
			return this;
		}
	
}


