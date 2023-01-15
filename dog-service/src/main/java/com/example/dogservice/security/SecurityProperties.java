package com.example.dogservice.security;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Application security configuration properties.
 */
@ConfigurationProperties("application.security")
public record SecurityProperties(List<UserProperties> users) {

}
