package com.example.dogservice.web;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.dogservice.service.NoSuchDogOwnerException;
import com.example.dogservice.service.OwnerService;

/**
 * Spring MVC controller for {@literal /owner}.
 */
@RestController
public class OwnerController {

	private final OwnerService ownerService;

	public OwnerController(OwnerService dogService) {
		this.ownerService = dogService;
	}

	@GetMapping("/owner/{name}/dogs")
	List<String> dog(@PathVariable String name) {
		return this.ownerService.getOwnedDogNames(name);
	}

	@ExceptionHandler
	ResponseEntity<Void> onNoSuchDogOwner(NoSuchDogOwnerException ex) {
		return ResponseEntity.notFound().build();
	}

}
