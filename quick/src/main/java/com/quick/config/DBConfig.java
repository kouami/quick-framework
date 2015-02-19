/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quick.config;

import javax.sql.DataSource;

/**
 *
 * @author u329022
 */
public abstract class DBConfig {
    
    public abstract DataSource dataSource();

}
