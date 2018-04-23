package charles.lab;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogHandler implements InvocationHandler{
  
  private Logger logger = Logger.getLogger(this.getClass().getName());
  
  private Object delegate;
  
  public Object bind(Object delegate){
    this.delegate = delegate;
    return Proxy.newProxyInstance(delegate.getClass().getClassLoader(), delegate.getClass().getInterfaces(), this);
  }
  
  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    Object reuslt = null;
    
    try{
      logger.log(Level.INFO, "method starts..." + method);
      reuslt = method.invoke(delegate, args);
      logger.log(Level.INFO, "method ends..." + method);
    }catch(Exception e){
      logger.log(Level.INFO,e.toString());
    }
    
    return reuslt;
  }

}
