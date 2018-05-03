package com.ch.myr.utils.aop.services;

import java.util.List;
import org.aspectj.lang.ProceedingJoinPoint;
import com.ch.myr.utils.aop.beans.LogObject;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface LogService {
  /**
   * Get default log object
   * 
   * @param pjp
   * @return
   */
  public LogObject getLogObject(String className, List inputArgs, String methodName);
  
  /**
   * get a new LogObject
   * @return
   */
  public LogObject getLogObject();
  
  /**
   * It will set outputArgs, endTime, and calculate duration, and write log.
   * @param obj
   * @param outputArgs
   * @throws JsonProcessingException 
   */
  public void record(LogObject obj, Object outputArgs) throws JsonProcessingException;
  
  /**
   * write log
   * @param log
   * @throws JsonProcessingException
   */
  public void log(LogObject log) throws JsonProcessingException;
}
