package com.example.springcodedemo.rest;

import com.example.springcodedemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class DemoController {
    // define a private field for dependence
    private Coach myCoach;


  @Autowired
  public void DemoController(@Qualifier("bored") Coach theCoach){
      System.out.println("In constructor: "+ getClass().getSimpleName());
      myCoach = theCoach;
  ;
  }

    @GetMapping("/DailyWorkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }


}
