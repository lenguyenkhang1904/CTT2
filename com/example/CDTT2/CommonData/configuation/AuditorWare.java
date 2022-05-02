package com.example.CDTT2.CommonData.configuation;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuditorWare implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {

		String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();

		return Optional.ofNullable(currentUsername);
	}
  
}
