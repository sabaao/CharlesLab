package com.cathay.holdings.services;

import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements IHelloService {

  @Override
  public String hello() {
    return "hello";
  }

}
