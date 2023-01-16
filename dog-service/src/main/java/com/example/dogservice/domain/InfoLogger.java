package com.example.dogservice.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * Logs database information at start up.
 */
@Component
public class InfoLogger implements ApplicationRunner {

	private static Logger log = LoggerFactory.getLogger(InfoLogger.class);

	private final OwnerRepository ownerRepository;

	private final DogRepository dogRepository;

	public InfoLogger(OwnerRepository ownerRepository, DogRepository dogRepository) {
		this.ownerRepository = ownerRepository;
		this.dogRepository = dogRepository;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.info("Found owners {}", this.ownerRepository.findAll());
		log.info("Found dogs {}", this.dogRepository.findAll());
	}

}
