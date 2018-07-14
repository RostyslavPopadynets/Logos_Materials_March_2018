package com.zavada.app;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class SpringOnlineCourcesFullProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringOnlineCourcesFullProjectApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

//	@Bean
//	public Module datetypeHibernateModule() {
//		return new Hibernate5Module();
//	}

//	@Bean
//	public Jackson2ObjectMapperBuilder configureObjectBuilder() {
//		return new Jackson2ObjectMapperBuilder().modulesToInstall(Hibernate5Module.class);
//	}
}
