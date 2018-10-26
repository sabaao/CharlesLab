package charles.lab.delegates;

import org.activiti.engine.delegate.DelegateExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import charles.lab.services.HelloService;

@Service("helloWorldDelegate")
public class HelloWorldDelegateImpl implements HelloWorldDelegate{
  
  @Autowired
  private HelloService service;
  
  @Override
  public void execute(DelegateExecution execution) throws Exception {
      
    System.out.println("variavles=" + execution.getVariables()); 
    System.out.println("service.sayHi() is " + service.sayHi());
    execution.setVariable("task4", "I am task 3");  
    System.out.println("I am task 4.");
    
  }

}
