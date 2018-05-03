package com.cathay.holdings.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController{

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String hello(@RequestParam String name){
        return "Hello " + name;
    }

}
