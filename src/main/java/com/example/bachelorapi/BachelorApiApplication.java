package com.example.bachelorapi;

import com.example.bachelorapi.model.Contestant;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;




@SpringBootApplication

public class BachelorApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BachelorApiApplication.class, args);
	}


}
