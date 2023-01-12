package com.example.dogservice.domain;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Spring Data repository for {@link Dog} entities.
 */
public interface DogRepository extends PagingAndSortingRepository<Dog, Long> {

	List<Dog> findByOwner(Owner owner);

}
