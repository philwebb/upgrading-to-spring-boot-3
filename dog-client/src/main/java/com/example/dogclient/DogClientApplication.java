package com.example.dogclient;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.ExchangeFilterFunctions;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@SpringBootApplication(proxyBeanMethods = false)
public class DogClientApplication {

	@Bean
	Api api(WebClient.Builder webClientBuilder) {
		WebClient webClient = webClientBuilder.baseUrl("http://localhost:8080")
				.filter(ExchangeFilterFunctions.basicAuthentication("user", "password")).build();
		HttpServiceProxyFactory factory = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(webClient)).build();
		return factory.createClient(Api.class);
	}

	@Bean
	ApplicationRunner applicationRunner(Api api) {
		return (args) -> {
			System.err.println(api.dogs(true));
			System.err.println(api.ownedDogs("phil"));
		};
	}

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(DogClientApplication.class);
		application.setWebApplicationType(WebApplicationType.NONE);
		application.run(args);
	}

}
