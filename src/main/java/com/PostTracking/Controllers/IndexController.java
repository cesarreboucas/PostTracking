package com.PostTracking.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Response the index of the application
 * @author 300296145
 *
 */
@Controller
public class IndexController {
	
	/**
	 * Maps the index of the application
	 * @return the Index View
	 */
	@GetMapping("/")
	public String home(  ) {
		return "index/index";
		
	}
}
