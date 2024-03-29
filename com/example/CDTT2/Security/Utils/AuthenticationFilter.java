package com.example.CDTT2.Security.Utils;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.CDTT2.User.repository.IUserRepository;


import lombok.AllArgsConstructor;

@Component
public class AuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private IUserRepository iUserRepository;
	
	@Autowired
	private JwtUltils jwtUltils;
	
	private Logger logger=LoggerFactory.getLogger(AuthenticationFilter.class);
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String token=jwtUltils.getTokenFromRequest(request);
		
		//bước 2 kiểm tra neesu đúng sẽ lấy user name có token đó ra
		if(token!=null && jwtUltils.validateToken(token))
		{
			String username=jwtUltils.getUsernameFromToken(token);    
			
			try {
				UserDetails userDetails=userDetailsService.loadUserByUsername(username);//Lấy toàn bộ Authorities (phân quyền) của user thông qua username 
				
				
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
				
			} catch (UsernameNotFoundException e) {
		
				logger.error("An anonymous user has been connected to server from {}", request.getRemoteAddr());
			}
			
		}
		
		filterChain.doFilter(request, response);
		
	}
	
	
 	
}
