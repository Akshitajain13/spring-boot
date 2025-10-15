package com.example.springcodedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*@SpringBootApplication(
        scanBasePackages = {"com.luv2code.springcoredemo",
                             "com.lov@code.util"})

 */
@SpringBootApplication
public class SpringcodedemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcodedemoApplication.class, args);
	}

}
