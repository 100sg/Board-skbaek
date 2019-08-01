package com.skbaek.board.config;


import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableJpaRepositories("com.skbaek.board")
@EnableTransactionManagement
@EntityScan
public class DatabaseConfig {
	
	@Bean(destroyMethod = "close", name = "dataSource")
	public DataSource dataSource(Environment env) {
		HikariConfig dsConfig = new HikariConfig();
//		dsConfig.setDriverClassName(env.getRequiredProperty("spring.datasource.hikari.driver-class-name"));
		dsConfig.setJdbcUrl(env.getRequiredProperty("spring.datasource.hikari.jdbc-url"));
		dsConfig.setUsername(env.getRequiredProperty("spring.datasource.hikari.username"));
		dsConfig.setPassword(env.getRequiredProperty("spring.datasource.hikari.password"));
		dsConfig.setMaxLifetime(Long.parseLong(env.getRequiredProperty("spring.datasource.hikari.max-lifetime")));
		dsConfig.setIdleTimeout(Long.parseLong(env.getRequiredProperty("spring.datasource.hikari.idle-timeout")));
		System.out.println("::" + dsConfig.toString());
		return new HikariDataSource(dsConfig);
	}
		
	@Bean(name = "entityManagerFactory")
    LocalContainerEntityManagerFactoryBean entityManagerFactory(@Qualifier("dataSource") DataSource dataSource, Environment env) {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setPackagesToScan("com.skbaek.board");
        Properties jpaProperties = new Properties();
        jpaProperties.put("hibernate.dialect", env.getRequiredProperty("spring.jpa.properties.hibernate.dialect"));
        jpaProperties.put("hibernate.hbm2ddl.auto", env.getRequiredProperty("spring.jpa.properties.hibernate.hbm2ddl.auto"));
        jpaProperties.put("hibernate.show_sql", env.getRequiredProperty("spring.jpa.show-sql"));
        jpaProperties.put("hibernate.format_sql", env.getRequiredProperty("spring.jpa.properties.hibernate.format_sql"));
        entityManagerFactoryBean.setJpaProperties(jpaProperties);
        return entityManagerFactoryBean;
    }
	
	@Bean(name = "transactionManager")
	PlatformTransactionManager transactionManager(@Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
	    transactionManager.setEntityManagerFactory(entityManagerFactory);
	    return transactionManager;
	    //return new DataSourceTransactionManager(dataSource)
	}
}
