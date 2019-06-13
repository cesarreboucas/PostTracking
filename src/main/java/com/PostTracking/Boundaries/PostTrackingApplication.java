package com.PostTracking.Boundaries;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan({"com.PostTracking.Controllers","com.PostTracking.Boundaries"})
@EntityScan("com.PostTracking.Entities")
public class PostTrackingApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostTrackingApplication.class, args);
		
	}

}
