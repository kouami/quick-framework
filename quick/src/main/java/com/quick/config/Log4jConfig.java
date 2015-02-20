/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quick.config;

import java.util.logging.Level;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.appender.ConsoleAppender;
import org.apache.logging.log4j.core.appender.FileAppender;
import org.apache.logging.log4j.core.appender.RollingFileAppender;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.layout.PatternLayout;
import org.springframework.context.annotation.Bean;


/**
 *
 * @author u329022
 */
//@Configuration
//@ImportResource({ "classpath:log4j.xml" })
public class Log4jConfig {

    /*
    @Bean
    public ConsoleAppender consoleAppender() {
        Configuration conf = new Configuration();
    }

    @Bean
    public FileAppender fileAppender() {
        RollingFileAppender fileAppender = new RollingFileAppender();
        fileAppender.setThreshold(Level.ALL);
        fileAppender.setFile("build.log");
        fileAppender.setMaxFileSize("100KB");
        fileAppender.setMaxBackupIndex(1);
        PatternLayout patternLayout = new PatternLayout();
        patternLayout.setConversionPattern("%d %-5p  [%c{1}] %m %n");
        fileAppender.setLayout(patternLayout);
        return fileAppender;
    }

    @Bean
    public Logger registerSpringLogger() {
        Logger logger = Logger.getLogger("org.springframework");
        logger.addAppender(consoleAppender());
        return logger;
    }

    @Bean
    public Logger registerThalasoftLogger() {
        Logger logger = Logger.getLogger("com.thalasoft");
        logger.setLevel(Level.DEBUG);
        logger.addAppender(consoleAppender());
        logger.addAppender(fileAppender());
        return logger;
    }

    @Bean
    public Logger registerHibernateTypeLogger() {
        Logger logger = Logger.getLogger("org.hibernate.type");
        logger.setLevel(Level.TRACE);
        logger.addAppender(consoleAppender());
        return logger;
    }

    @Bean
    public Logger registerHibernateSqlLogger() {
        Logger logger = Logger.getLogger("org.hibernate.sql");
        logger.setLevel(Level.DEBUG);
        logger.addAppender(consoleAppender());
        return logger;
    }

    @Bean
    public Logger registerJdbcSqlOnlyLogger() {
        Logger logger = Logger.getLogger("jdbc.sqlonly");
        logger.setLevel(Level.TRACE);
        logger.setAdditivity(false);
        logger.addAppender(consoleAppender());
        logger.addAppender(fileAppender());
        return logger;
    }
    */
}
