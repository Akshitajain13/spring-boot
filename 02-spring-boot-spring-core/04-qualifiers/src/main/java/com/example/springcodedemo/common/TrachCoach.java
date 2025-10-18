package com.example.springcodedemo.common;

import org.springframework.stereotype.Component;

@Component
public class TrachCoach implements Coach {
    @Override
    public String getDailyWorkout(){
        return "Run a hard 5k!";
    }

}
