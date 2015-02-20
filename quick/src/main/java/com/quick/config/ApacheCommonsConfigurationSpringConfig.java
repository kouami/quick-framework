/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quick.config;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author u329022
 */
@Configuration
public class ApacheCommonsConfigurationSpringConfig {
    
    private static final String CONFIG_LOCATION_CLASSPATH = "commons-config.xml";
    
    @Bean
    public XMLConfiguration xmlConfig() throws ConfigurationException{
        return new XMLConfiguration(CONFIG_LOCATION_CLASSPATH);
    }
    
    /* For Testing Purpose
    public static void main(String[] args) throws ConfigurationException {
        XMLConfiguration config = new XMLConfiguration("commons-config.xml");
        String[] countries = config.getStringArray("countries.country.code");
        System.out.println(countries.length);
    }*/
}
