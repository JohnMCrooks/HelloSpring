/*
 * Copyright (c) 2016.
 */

package com.crooks;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by johncrooks on 6/20/16.
 */

@Controller
public class HelloSpringController {
    @RequestMapping(path = "/", method = RequestMethod.GET)                  //Creating the main route
    public String home(Model model, String name, String city, Integer age){     //specifies parameters for variables to be passed  //using Integer instead of int makes it an optional argument
        if (name==null){
            name = "alice";
        }
        if (city == null){
            city = "charleston";

        }
        if (age == null){
            age = 40;
        }

        Person person = new Person(name, city, age);

        model.addAttribute("person", person);
        return "person";   //this looks for person.html even though you aren't specifically stating that you want the .html

    }

}
