package com.example.dogservice.service;

/**
 * Exception thrown when a dog owner cannot be found.
 */
public class NoSuchDogOwnerException extends RuntimeException {

	private final String name;

	NoSuchDogOwnerException(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

}
