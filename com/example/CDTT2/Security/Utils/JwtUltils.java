package com.example.CDTT2.Security.Utils;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtUltils {

	private static final Logger logger = LoggerFactory.getLogger(JwtUltils.class);

	public String jwtToken(Authentication authentication) {

		UserDetails userDetails = (UserDetails) authentication.getPrincipal();

		return Jwts.builder().setSubject(userDetails.getUsername())
				.setExpiration(new Date(new Date().getTime() + 60000000))
				.setIssuedAt(new Date())
				.signWith(SignatureAlgorithm.HS256, "CDTT2").compact();
	}

	public boolean validateToken(String token) {
		try {
			Jwts.parser().setSigningKey("CDTT2").parseClaimsJws(token);
			return true;

		} catch (ExpiredJwtException e) {
			logger.error("JWT Token is Experied: {}", e.getMessage()); // e.getMessage đẩy vào {}

		} catch (MalformedJwtException e) {
			logger.error("JWT Token is invalid: {}", e.getMessage());
		} catch (SignatureException e) {
			logger.error("JWT Token is incorrect Signature: {}", e.getMessage());
		} catch (IllegalArgumentException e) {
			logger.error("JWT Token is empty: {}", e.getMessage());
		} catch (UnsupportedJwtException e) {
			logger.error("JWT Token is unsupported : {}", e.getMessage());
		}

		return false;
	}

	public String getTokenFromRequest(HttpServletRequest request) {
		String header=request.getHeader("Authorization");
		if(header!=null && header.startsWith("Bearer "))
			return header.substring("Bearer ".length(),header.length());
		return null;
	}

	public static String getUsernameFromToken(String token) {
		
		return Jwts.parser().setSigningKey("CDTT2").parseClaimsJws(token).getBody().getSubject();
	}

}
