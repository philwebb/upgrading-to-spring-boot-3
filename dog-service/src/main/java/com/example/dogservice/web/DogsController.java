package com.example.dogservice.web;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring MVC controller for {@literal /dogs}.
 */
@RestController
@RequestMapping
public class DogsController {

	@GetMapping("/dogs")
	public Map<String, String> dogs(@RequestParam(name = "aregood") boolean areGood) {
		String message = (!areGood) ? "Go find a cat service!" : "We <3 dogs!!!";
		return Map.of("message", message);
	}

}
