package com.example.dogservice.domain;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;

/**
 * Spring Data repository for {@link Dog} entities.
 */
public interface DogRepository extends ListCrudRepository<Dog, Long>, ListPagingAndSortingRepository<Dog, Long> {

	List<Dog> findByOwner(Owner owner);

}
