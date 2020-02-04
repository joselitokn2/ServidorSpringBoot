package com.springboot.jose.rest.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableJpaAuditing
public class MiConfiguracion {

	
	@Bean
	public ModelMapper modelmapper() {
		return new ModelMapper();
	}

	/**
	 * Configuración más básica. Por defecto se permite
	 * - Todos los orígnenes
	 * - Métodos GET, HEAD, POST
	 * 
	 */
	
//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurer() {
//
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/**");
//			}
//			
//		};
//	}
	
	/**
	 * Configuración más ajustada.
	 */
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {

			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/producto/**")
					.allowedOrigins("http://localhost:9000")
					.allowedMethods("GET", "POST", "PUT", "DELETE")
					.maxAge(3600);
			}
			
		};
	}
	
}
