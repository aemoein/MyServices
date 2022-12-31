package com.MyServices.Main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.MyServices.Main"})

/*
@ComponentScan(basePackages = {"com.MyServices.Main.User"})
@ComponentScan(basePackages = {"com.MyServices.Main.Payment"})
@ComponentScan(basePackages = {"com.MyServices.Main.Service"})
@ComponentScan(basePackages = {"com.MyServices.Main.Transaction"})
*/

public class MyServicesApplication {

	public static void main(String[] args) 
	{
		SpringApplication.run(MyServicesApplication.class, args);
		SystemEntry systemEntry = new SystemEntry();
		systemEntry.SystemStart();
	}

}