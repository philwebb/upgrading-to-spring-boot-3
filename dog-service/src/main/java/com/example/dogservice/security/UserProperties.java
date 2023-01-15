package com.example.dogservice.security;

import java.util.List;

/**
 * User properties as defined in the {@link SecurityConfiguration}.
 */
public record UserProperties(String name, String password, List<String> roles) {

}
