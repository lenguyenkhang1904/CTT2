package com.example.CDTT2.CommonData.configuation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Component;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class JpaConfig {

	
	@Bean
	AuditorAware<String> auditorAware()
	{
		return new AuditorWare();
	}
	
	@Component
	public interface IGennericRepository<T,ID> extends JpaRepository<T, ID>
	{
		
	}
}
