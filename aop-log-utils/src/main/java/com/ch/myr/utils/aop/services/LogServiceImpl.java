package com.ch.myr.utils.aop.services;

import java.util.Date;
import java.util.List;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.ch.myr.utils.aop.beans.LogObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;

@Service
public class LogServiceImpl implements LogService {
  
  private Logger logger = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
  private Level rootLevel = logger.getLevel();
  
  @Override
  public LogObject getLogObject(String className, List inputArgs, String methodName) {
    LogObject log = getLogObject();
    log.setClassName(className);
    log.setInputArgs(inputArgs);
    log.setMethodName(methodName);
    return log;
  }

  @Override
  public LogObject getLogObject() {
    LogObject log = new LogObject();
    log.setStartTime(new Date());
    return log;
  }

  @Override
  public void record(LogObject obj, Object outputArgs) throws JsonProcessingException {
    obj.setOutputArgs(outputArgs);
    obj.setEndTime(new Date());
    obj.setDuration((obj.getEndTime().getTime() - obj.getStartTime().getTime()));
    log(obj);

  }

  @Override
  public void log(LogObject log) throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    String value = mapper.writeValueAsString(log);
    switch(rootLevel.levelInt) {
      case Level.ERROR_INT:
        logger.error(value);
        break;
      case Level.WARN_INT:
        logger.warn(value);
        break;
      case Level.INFO_INT:
        logger.info(value);
        break;
      case Level.DEBUG_INT:
        logger.debug(value);
        break;
      case Level.TRACE_INT:
        logger.trace(value);
        break;
      case Level.ALL_INT:
        logger.error(value);
        break;
      default:
        logger.error(value);
        break;
    }
  }

}
