package com.lab5.Entity.Mapping.and.Persistence.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching  // This annotation enables Spring’s annotation-driven cache management capability
public class CacheConfig {
    // Additional cache configuration can go here, such as using specific cache managers
}
