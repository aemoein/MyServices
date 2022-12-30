package com.MyServices.Main;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {

	@GetMapping ("/test")
	public void test() {
		System.out.println("SUIIIIII");
	}
}
