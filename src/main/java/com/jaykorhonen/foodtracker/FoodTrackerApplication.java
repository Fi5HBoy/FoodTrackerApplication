package com.jaykorhonen.foodtracker;

/**
 * TODO: Finish implementing unsecured routs for food, meal, and menu items
 * TODO: Custom insert or delete?
 * TODO: Secure application with ldap https://spring.io/guides/gs/authenticating-ldap/
 * TODO: React frontend
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FoodTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodTrackerApplication.class, args);
	}

}
