package com.example.CDTT2.Security.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.boot.autoconfigure.web.servlet.DefaultJerseyApplicationPath;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.CDTT2.Role.model.Role;
import com.example.CDTT2.Security.Dto.UserDetailDto;
import com.example.CDTT2.User.model.User;
import com.example.CDTT2.User.repository.IUserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserDetailServiceIMPL implements UserDetailsService {

	private IUserRepository iUserRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		Optional<User> user=iUserRepository.findByUsername(username);
		
		if(user.isEmpty())
			throw new UsernameNotFoundException("username is invalid");
		
		
		Set<GrantedAuthority> grantedAuthorities = getAuthorities(user.get().getRoles());
		
		return new UserDetailDto(user.get().getUsername(), user.get().getPassword(), grantedAuthorities);
	}

	private Set<GrantedAuthority> getAuthorities(Set<Role> roles) {
		
		Set<GrantedAuthority> grantedAuthorities=new HashSet<>();
		
		for (Role role : roles) {
			SimpleGrantedAuthority simpleGrantedAuthority=new SimpleGrantedAuthority(role.getRoleName());
			grantedAuthorities.add(simpleGrantedAuthority);
		}
		
		return grantedAuthorities;
	}

}
