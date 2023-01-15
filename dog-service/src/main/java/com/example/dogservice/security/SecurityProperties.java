package com.example.dogservice.security;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Application security configuration properties.
 */
@ConfigurationProperties("application.security")
public class SecurityProperties {

	private final List<UserProperties> users;

	public SecurityProperties(List<UserProperties> users) {
		this.users = users;
	}

	public List<UserProperties> getUsers() {
		return this.users;
	}

}
