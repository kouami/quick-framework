/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quick.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 *
 * @author u329022
 */
@Configuration
@EnableTransactionManagement
@PropertySources({
    @PropertySource("classpath:jdbc.properties")
})
@ComponentScan({ "com.quick" })
public class HibernateConfig extends DBConfig {

	@Autowired
	private Environment env;

	@Value("${jdbc.url}")
	private String jdbcUrl;

	@Value("${jdbc.driverClassName}")
	private String driverClassName;

	@Value("${jdbc.username}")
	private String username;

	@Value("${jdbc.password}")
	private String password;

	@Bean(/* initMethod = "setup", destroyMethod = "cleanup" */)
	@Override
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(driverClassName);
		ds.setUrl(jdbcUrl);
		ds.setUsername(username);
		ds.setPassword(password);

		return ds;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(new String[] { "com.quick.entities" });
		sessionFactory
		.setConfigLocations(new ClassPathResource[] { new ClassPathResource(
				"hibernate.cfg.xml") });
		sessionFactory.setHibernateProperties(hibernateProperties());

		return sessionFactory;
	}

	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(
			SessionFactory sessionFactory) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);
		return txManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}



	@Bean 
	public static PropertyPlaceholderConfigurer propertyPlaceholderConfigurer(){ 
		PropertyPlaceholderConfigurer p = new PropertyPlaceholderConfigurer(); 
		ClassPathResource[] resources = new ClassPathResource[]{ new ClassPathResource( "jdbc.properties" ) };
	    p.setLocations(resources); p.setIgnoreResourceNotFound(true);
	    p.setIgnoreUnresolvablePlaceholders(true); 
	    return p; 
	    
	}


	@Bean
	Properties hibernateProperties() {
		Properties p = new Properties();

		p.setProperty("hibernate.hbm2ddl.auto", "create");
		p.setProperty("hibernate.connection.autocommit", "true");
		p.setProperty("hibernate.show_sql", "true");

		return p;
	}

}
