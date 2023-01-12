package com.example.dogservice.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * JPA entity for a dog owner.
 */
@Entity
public class Owner {

	@Id
	private long id;

	private String name;

	Owner() {
	}

	public Owner(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public String toString() {
		return this.name;
	}

}
