/*
 * Copyright (c) 2016.
 */

package com.crooks;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by johncrooks on 6/20/16.
 */

@Controller
public class HelloSpringController {


    @RequestMapping(path = "/", method = RequestMethod.GET)                  //Creating the main route
    public String home(Model model, HttpSession session, String name, String city, Integer age){     //specifies parameters for variables to be passed  //using Integer instead of int makes it an optional argument
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
        model.addAttribute("person", person);                    //Need this line to make mustache work

        String username = (String) session.getAttribute("username");  //grabs username out of the session // Has to be cast as a String because it's kinda dumb
        User user = null;
        if (username!=null){                                     //if username isn't null create a new user
            user = new User(username);
        }
        model.addAttribute("user", user);                        //add user to the model (AKA link it to the HTML)
        return "person";                                         //this looks for person.html template even though you aren't specifically stating that you want the .html
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(String username, HttpSession session){
        session.setAttribute("username", username);             //must match the html usage exactly
        return "redirect:/";                                     //redirects back to the "/" route

    }

    @RequestMapping(path = "/logout", method = RequestMethod.POST)
        public String logout(HttpSession session) {
            session.invalidate();
            return "redirect:/";
        }



}
