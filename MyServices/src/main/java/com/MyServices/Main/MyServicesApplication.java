package com.MyServices.Main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyServicesApplication {

	public static void main(String[] args) 
	{
		SpringApplication.run(MyServicesApplication.class, args);
		SystemEntry systemEntry = new SystemEntry();
		systemEntry.SystemStart();
	}

}