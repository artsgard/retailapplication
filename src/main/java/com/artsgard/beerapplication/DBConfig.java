package com.artsgard.beerapplication;

import javax.sql.DataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 *
 * @author artsgard
 */
@Configuration
@ConfigurationProperties("spring.datasource")
public class DBConfig {

    @Profile("prod")
    @Bean(name = "postgresDataSource")
    public DataSource devDatabaseConnection() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:postgresql://localhost:5432/product_purchase_db");
        dataSourceBuilder.username("postgres");
        dataSourceBuilder.password("Candita123");
        return dataSourceBuilder.build();
    }

    @Profile("test")
    @Bean(name = "h2DataSource")
    public DataSource testDatabaseConnection() {
          DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:h2:mem:test_db");
        dataSourceBuilder.username("sa");
        dataSourceBuilder.password("sa");
        return dataSourceBuilder.build();
    }

    @Profile("dev")
    @Bean
    public DataSource prodDatabaseConnection() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:mysql://localhost:3306/product_purchase_db?createDatabaseIfNotExist=true&useUnicode=yes&characterEncoding=UTF-8&useLegacyDatetimeCode=false&serverTimezone=UTC");
        dataSourceBuilder.username("root");
        dataSourceBuilder.password("Candita123");
        return dataSourceBuilder.build();
    }
}

