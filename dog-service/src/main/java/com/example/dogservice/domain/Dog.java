package com.example.dogservice.domain;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
		return String.format("%s owned by %s", this.name, this.owner);
	}

}
