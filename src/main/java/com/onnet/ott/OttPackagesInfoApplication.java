package com.onnet.ott;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })

public class OttPackagesInfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(OttPackagesInfoApplication.class, args);
	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/*").allowedOrigins("http://134.209.148.41:8060")
				.allowedMethods("GET", "PUT", "POST", "DELETE").allowedHeaders("*");
			}
		};
	}

}
