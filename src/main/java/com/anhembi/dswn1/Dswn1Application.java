package com.anhembi.dswn1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;


@SpringBootApplication
public class Dswn1Application {
	public static void main(String[] args) {
		SpringApplication.run(Dswn1Application.class, args);
	}
	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://dpg-cks6dj7d47qs73av0pbg-a.oregon-postgres.render.com:5432/pawsome");
		dataSource.setUsername("admin");
		dataSource.setPassword("H4Ssc3NrxCX3VsPA7f2IcElzxQYoV2AF");
		return dataSource;
	}

}
