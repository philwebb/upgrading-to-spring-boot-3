	package com.example.dogservice.domain;

import org.springframework.data.repository.CrudRepository;

/**
 * Spring Data repository for {@link Owner} entities.
 */
public interface OwnerRepository extends CrudRepository<Owner, Long> {

	Owner findByNameIgnoringCase(String name);

}
