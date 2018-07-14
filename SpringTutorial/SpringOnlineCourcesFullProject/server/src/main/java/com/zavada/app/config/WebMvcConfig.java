package com.zavada.app.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;

@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "POST", "PUT", "DELETE")
				.allowedHeaders("Content-Type", "Access-Control-Allow-Origin", "Access-Control-Allow-Headers",
						"Authorization", "X-Requested-With")
				.allowCredentials(true).maxAge(3600);
	}


//	@Override
//	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//		converters.add(jacksonMessageConverter());
//		WebMvcConfigurer.super.configureMessageConverters(converters);
//	}
//
//	public MappingJackson2HttpMessageConverter jacksonMessageConverter() {
//		MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
//
//		ObjectMapper mapper = new ObjectMapper();
//		mapper.registerModule(new Hibernate5Module());
//		messageConverter.setObjectMapper(mapper);
//		return messageConverter;
//	}
}
