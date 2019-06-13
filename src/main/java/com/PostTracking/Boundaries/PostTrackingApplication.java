package com.PostTracking.Boundaries;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("com.PostTracking.Controllers")
public class PostTrackingApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostTrackingApplication.class, args);
		
	}

}
