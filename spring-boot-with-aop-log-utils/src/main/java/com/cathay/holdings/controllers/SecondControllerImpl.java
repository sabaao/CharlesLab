package com.cathay.holdings.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.cathay.holdings.services.IHelloService;

@RestController
public class SecondControllerImpl implements SecondController {
  
  @Autowired
  private IHelloService helloService;
  
  @RequestMapping(value = "/seconds", method = RequestMethod.GET)
  @ResponseBody
  @Override
  public String hello() {
    return helloService.hello();
  }

}
