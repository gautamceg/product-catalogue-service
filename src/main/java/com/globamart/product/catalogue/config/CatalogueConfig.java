package com.globamart.product.catalogue.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages={"com.globamart.product.catalogue.repository"})
public class CatalogueConfig {

}
