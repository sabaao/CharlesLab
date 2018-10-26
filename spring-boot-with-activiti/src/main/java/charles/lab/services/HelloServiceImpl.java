package charles.lab.services;

import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

  @Override
  public String sayHi() {
    return "hi";
  }

}
