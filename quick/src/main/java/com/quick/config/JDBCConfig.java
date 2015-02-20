/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quick.config;

import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author u329022
 */
public class JDBCConfig extends DBConfig {
    
    @Bean
    @Override
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(org.hsqldb.jdbcDriver.class.getName());
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        dataSource.setUrl("jdbc:hsqldb:mem:mydb");
        return dataSource;
    }
    
    @Bean(initMethod = "setup", destroyMethod = "cleanup")
    @Autowired
    public JdbcTemplate jdbcTemplate(DataSource ds){
        return new JdbcTemplate(ds);
    }
}
