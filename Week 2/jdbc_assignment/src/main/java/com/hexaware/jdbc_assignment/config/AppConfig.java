package com.hexaware.jdbc_assignment.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = "com.hexaware.jdbc_assignment")
@PropertySource("classpath:resources/database.properties")
public class AppConfig {
	
	@Autowired
	Environment env;
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource source = new DriverManagerDataSource();
		
		source.setUrl(env.getProperty("url"));
		source.setUsername(env.getProperty("user"));
		source.setPassword(env.getProperty("password"));
		
		return source;
	}
}
