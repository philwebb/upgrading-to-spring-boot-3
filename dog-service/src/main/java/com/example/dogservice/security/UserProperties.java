package com.example.dogservice.security;

import java.util.List;

/**
 * User properties as defined in the {@link SecurityConfiguration}.
 */
public class UserProperties {

	private final String name;

	private final String password;

	private List<String> roles;

	public UserProperties(String name, String password, List<String> roles) {
		this.name = name;
		this.password = password;
		this.roles = roles;
	}

	public String getName() {
		return this.name;
	}

	public String getPassword() {
		return this.password;
	}

	public List<String> getRoles() {
		return this.roles;
	}

}
