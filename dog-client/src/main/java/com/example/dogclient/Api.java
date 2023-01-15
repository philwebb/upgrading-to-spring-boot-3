package com.example.dogclient;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

public interface Api {

	@GetExchange("/dogs")
	DogsResponse dogs(@RequestParam(name = "aregood") boolean areGood);

	@GetExchange("/owner/{name}/dogs")
	List<String> ownedDogs(@PathVariable String name);

}
