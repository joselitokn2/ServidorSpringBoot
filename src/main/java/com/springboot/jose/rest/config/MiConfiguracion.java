package com.springboot.jose.rest.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MiConfiguracion {

	
	@Bean
	public ModelMapper modelmapper() {
		return new ModelMapper();
	}
	@Bean
	public WebMvcConfigurer corsConfig() {
		return new WebMvcConfigurer() {

			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:9000")
						.allowedMethods("GET", "POST", "PUT", "DELETE").maxAge(3600);
			}

		};
	}
}
