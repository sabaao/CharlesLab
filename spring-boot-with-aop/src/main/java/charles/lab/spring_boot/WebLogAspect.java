package charles.lab.spring_boot;

import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import org.aopalliance.intercept.Joinpoint;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class WebLogAspect {
  private Logger logger = Logger.getLogger(getClass());
  
  @Pointcut("execution(public * charles.lab.spring_boot..*.*(..))")
  public void webLog(){}
  
  @Before("webLog()")
  public void doBefore(JoinPoint joinPoint) throws Throwable{
    //get request, record request's content
    ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    HttpServletRequest request = attributes.getRequest();
    
    //record request content
    logger.info("url : " + request.getRequestURL().toString());
    logger.info("http method : " + request.getMethod());
    logger.info("ip : " + request.getRemoteAddr());
    logger.info("class method : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
    logger.info("args : " + Arrays.toString(joinPoint.getArgs()));
  }
  
  @AfterReturning(returning="ret", pointcut="webLog()")
  public void doAfterReturning(Object ret) throws Throwable{
    logger.info("response : " + ret);
  }
  
}
