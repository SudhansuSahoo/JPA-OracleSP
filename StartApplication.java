package com.hig.oracleformsmigration;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class StartApplication {

	public static void main(String[] args) {
		SpringApplication.run(StartApplication.class, args);
	}

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(StartApplication.class);
	}
	
	/*
	 * @SuppressWarnings("deprecation")
	 * 
	 * @Bean public SessionFactory sessionFactory(HibernateEntityManagerFactory
	 * hemf) { return hemf.getSessionFactory(); }
	 */

	@RequestMapping(value = "/test")
	public String hello() {
		return "Hello World from Tomcat111";
	}
	
}
