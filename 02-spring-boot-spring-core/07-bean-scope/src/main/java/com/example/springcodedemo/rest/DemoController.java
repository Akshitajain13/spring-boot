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
    private Coach anotherCoach;

  @Autowired
  public void DemoController (@Qualifier("cricketCoach") Coach theCoach,
                              @Qualifier("cricketCoach") Coach theAnotherCoach){
      System.out.println("In constructor: "+ getClass().getSimpleName());
      myCoach = theCoach;
      anotherCoach=theAnotherCoach;
  }

    @GetMapping("/DailyWorkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
    @GetMapping("check")
    public String Check(){
      return "Comparing beans: myCoach==anotherCoach," +(myCoach==anotherCoach);
    }

}
