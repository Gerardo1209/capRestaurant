package com.capgemini.bootcamp.java.excerciseone.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogConfiguration {

    @Bean
    public LogManager createLogManager(){
        return new LogManagerImp("product.log");
    }

}
