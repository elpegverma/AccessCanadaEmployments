package com.info.Access;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@ComponentScan({"com.info.Access"})
@EntityScan("com.info.Access.Entity")
@EnableJpaRepositories("com.info.Access.repo")
@RestController
public class AccessApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(AccessApplication.class, args);
	}
	
	@Override
	 protected SpringApplicationBuilder configure(SpringApplicationBuilder application)   
	{  
	return application.sources(AccessApplication.class);  
	} 
	  
	@GetMapping("/h")
	public String getHomePage()
	{
		return "Hi Admin";
	}
	

}
