package com.workintech.s17d2;

import com.workintech.s17d2.rest.tax.Taxable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class S17d2Application {

	public static void main(String[] args) {
		SpringApplication.run(S17d2Application.class, args);
	}

	@RestController
	@RequestMapping("/developer")
	public static class DeveloperController {
		public DeveloperController(DeveloperTax developerTax) {
		}


	}


}
