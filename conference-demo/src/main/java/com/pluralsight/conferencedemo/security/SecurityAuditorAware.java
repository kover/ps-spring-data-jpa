package com.pluralsight.conferencedemo.security;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class SecurityAuditorAware implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("Konstantin");
    }
}
