package com.demo.sales_erp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.demo.sales_erp","com.speedment.jpastreamer"})
public class SalesErpApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesErpApplication.class, args);
	}

}
