package com.example.dogservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.dogservice.domain.Dog;
import com.example.dogservice.domain.DogRepository;
import com.example.dogservice.domain.Owner;
import com.example.dogservice.domain.OwnerRepository;

import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;

/**
 * Dog owner service.
 */
@Service
public class OwnerService {

	private final OwnerRepository ownerRepository;

	private final DogRepository dogRepository;

	private final ObservationRegistry observationRegistry;

	public OwnerService(OwnerRepository ownerRepository, DogRepository dogRepository,
			ObservationRegistry observationRegistry) {
		this.ownerRepository = ownerRepository;
		this.dogRepository = dogRepository;
		this.observationRegistry = observationRegistry;
	}

	public List<String> getOwnedDogNames(String ownerName) {
		Observation observation = Observation.createNotStarted("owner", observationRegistry)
				.contextualName("getting-owned-dogs").highCardinalityKeyValue("ownerName", ownerName);
		return observation.observe(() -> {
			Owner owner = this.ownerRepository.findByNameIgnoringCase(ownerName);
			if (owner == null) {
				throw new NoSuchDogOwnerException(ownerName);
			}
			return this.dogRepository.findByOwner(owner).stream().map(Dog::getName).toList();
		});
	}

}
