package com.example.springcodedemo.config;

import com.example.springcodedemo.common.Coach;
import com.example.springcodedemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    @Bean("bored")
    public Coach swimCoach(){
        return new SwimCoach();
    }

}
