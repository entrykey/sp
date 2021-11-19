package com.sp.spmain;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.FlywayException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SpringBootApplication
public class SpmainApplication {
	
	private Logger log = LogManager.getLogger(SpmainApplication.class);
	@Autowired private Flyway flyway;
	
	public static void main(String[] args) {
		SpringApplication.run(SpmainApplication.class, args);
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public void initialConfiguration() {
		try {
			flyway.migrate();
		} catch (FlywayException e) {
			log.error(e.getLocalizedMessage());
		}
		
	}

}
