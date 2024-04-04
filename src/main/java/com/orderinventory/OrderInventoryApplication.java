package com.orderinventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@EnableAutoConfiguration
@ComponentScan("com.orderinventory")
public class OrderInventoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderInventoryApplication.class, args);
	}

}
