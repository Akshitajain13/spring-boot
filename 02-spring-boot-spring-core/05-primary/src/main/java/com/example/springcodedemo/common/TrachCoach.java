package com.example.springcodedemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class TrachCoach implements Coach {
    @Override
    public String getDailyWorkout(){
        return "Run a hard 5k!";
    }

}
