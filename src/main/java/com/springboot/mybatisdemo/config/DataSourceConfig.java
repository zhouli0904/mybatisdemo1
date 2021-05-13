package com.springboot.mybatisdemo.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean("testDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.test")
    public DataSource testDataSource() {
        HikariDataSource hikariDataSource = new HikariDataSource();
        // 自定义
        hikariDataSource.setConnectionTimeout(20000);
        hikariDataSource.setPoolName("test-pool");
        hikariDataSource.setMaximumPoolSize(100);
        return hikariDataSource;
    }

    @Bean("zlDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.zl")
    public DataSource zlDataSource() {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setConnectionTimeout(20000);
        hikariDataSource.setPoolName("zl-pool");
        hikariDataSource.setMaximumPoolSize(100);
        return hikariDataSource;
    }

}
