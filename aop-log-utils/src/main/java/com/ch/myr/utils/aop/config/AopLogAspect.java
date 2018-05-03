package com.ch.myr.utils.aop.config;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ch.myr.utils.aop.beans.LogObject;
import com.ch.myr.utils.aop.services.ConfigService;
import com.ch.myr.utils.aop.services.LogService;
import com.ch.myr.utils.aop.services.ScanService;

@Aspect
@Component
public class AopLogAspect {
  /**
   * 分隔符號
   */
  private final static String SPLIT_SYMBOL = ",";
  
  @Autowired
  private LogService logService;
  
  @Autowired
  private ConfigService configService;
  
  @Autowired
  private ScanService scanService;
  
  private Set<String> staticScanNamesSet;

  @PostConstruct
  public void init() {
    // convert staticScanPackages to set
    staticScanNamesSet = new HashSet<String>(Arrays.asList(configService.getStaticScanNames().split(SPLIT_SYMBOL)));
  }

  @Pointcut("@within(org.springframework.web.bind.annotation.RestController)")
  private void cutRestController() {}

  @Pointcut("@within(org.springframework.stereotype.Service) && !execution(* com.ch.myr.utils.aop..*.*(..))")
  private void cutService() {}

  @Pointcut("@within(org.springframework.stereotype.Repository) && !execution(* com.ch.myr.utils.aop..*.*(..))")
  private void cutRepository() {}

  @Pointcut("@within(org.springframework.stereotype.Component) && !execution(* com.ch.myr.utils.aop..*.*(..))")
  private void cutComponent() {}
  
  @Around("cutRestController() || cutService() || cutRepository() || cutComponent()")
  public Object around(ProceedingJoinPoint pjp) throws Throwable {
    String fullName = pjp.getSignature().getDeclaringTypeName();
    
    boolean isNeedLog = scanService.isInScanNames(fullName);
    Object result = null;
    if (isNeedLog) {
      // init log object
      LogObject log = logService.getLogObject(pjp.getSignature().getDeclaringTypeName(),Arrays.asList(pjp.getArgs()),pjp.getSignature().getName());
      try {
        // run method
        result = pjp.proceed();
      } catch (Exception e) {
        log.setExceptionMessage(e.getMessage());
        throw e;
      } finally {
        // record log
        logService.record(log, result);
      }
    } else {
      // don't need record log
      result = pjp.proceed();
    }

    return result;
  }
}
