package vbm.common.database.configuration;

import org.springframework.context.annotation.Configuration;

@Configuration
@EnableJpaRepositories(
        basePackages = "vbm.common"
)
@EnableJpaAuditing
public class DatabaseConfiguration {
}
