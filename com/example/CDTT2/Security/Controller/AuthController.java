package com.example.CDTT2.Security.Controller;

import org.apache.catalina.authenticator.SpnegoAuthenticator.AuthenticateAction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CDTT2.CommonData.ResponseHandler.ResponseHandler;
import com.example.CDTT2.Security.Dto.JwtDto;
import com.example.CDTT2.Security.Dto.LoginDto;
import com.example.CDTT2.Security.Utils.JwtUltils;
import com.example.CDTT2.User.model.User;

import lombok.AllArgsConstructor;

@RequestMapping("/api/auth")
@RestController
@AllArgsConstructor
public class AuthController {

	private AuthenticationManager authenticationManager;

	private JwtUltils jwtUltils;

	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody LoginDto dto) {
		Authentication authentication = null;

		try {
				authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword()));
				
				SecurityContextHolder.getContext().setAuthentication(authentication);
						
				String jwt=jwtUltils.jwtToken(authentication);
				
				return ResponseHandler.getResponse(new JwtDto().gẹtwtDto(jwt), HttpStatus.OK);
			} catch (AuthenticationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ResponseHandler.getResponse("invalid username and Password", HttpStatus.BAD_REQUEST);
	}
	
}
