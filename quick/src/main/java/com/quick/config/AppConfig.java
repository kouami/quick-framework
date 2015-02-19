/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quick.config;

import org.springframework.context.annotation.Import;

/**
 *
 * @author Emmanuel
 */
@Import({MvcConfiguration.class/*,FreemarkerConfig.class*/})
public class AppConfig {
}
