package com.example.dogservice.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 * JPA entity for a dog.
 */
@Entity
public class Dog {

	@Id
	private long id;

	private String name;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "dog_owner_fkey"))
	private Owner owner;

	Dog() {
	}

	public Dog(long id, String name, Owner owner) {
		this.id = id;
		this.name = name;
	}

	public long getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public Owner getOwner() {
		return this.owner;
	}

	@Override
	public String toString() {
		return "%s owned by %s".formatted(this.name, this.owner);
	}

}
