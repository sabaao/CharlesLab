package charles.lab.delegates;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class JavaDeledgateImpl implements JavaDelegate{

  @Override
  public void execute(DelegateExecution execution) throws Exception {
    System.out.println("this is JavaDeledgateImpl");
    
  }

}
