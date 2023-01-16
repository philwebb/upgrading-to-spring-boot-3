	package com.example.dogservice.domain;

import org.springframework.data.repository.ListCrudRepository;

/**
 * Spring Data repository for {@link Owner} entities.
 */
public interface OwnerRepository extends ListCrudRepository<Owner, Long> {

	Owner findByNameIgnoringCase(String name);

}
