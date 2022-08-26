package com.CRM.CRM;

import com.CRM.CRM.data.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrmApplication implements CommandLineRunner {

	@Autowired
	Menu menu;

	public static void main(String[] args) {
		SpringApplication.run(CrmApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
	 menu.start();
	}
}
