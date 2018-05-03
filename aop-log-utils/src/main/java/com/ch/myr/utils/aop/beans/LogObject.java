package com.ch.myr.utils.aop.beans;

import java.util.Date;
import java.util.List;

public class LogObject {
  
  /**
   * class name
   */
  private String className;
  
  /**
   * method name
   */
  private String methodName;
  
  /**
   * 輸入參數
   */
  private List inputArgs;
  
  /**
   * return參數
   */
  private Object outputArgs;
  
  /**
   * 開始執行時間
   */
  private Date startTime;
  
  /**
   * 結束時間
   */
  private Date endTime;
  
  /**
   * 執行了多久
   */
  private long duration;
  
  /**
   * 錯誤訊息
   */
  private String exceptionMessage;
  
  public String getClassName() {
    return className;
  }
  public void setClassName(String className) {
    this.className = className;
  }
  public String getMethodName() {
    return methodName;
  }
  public void setMethodName(String methodName) {
    this.methodName = methodName;
  }
  
  public List getInputArgs() {
    return inputArgs;
  }
  public void setInputArgs(List inputArgs) {
    this.inputArgs = inputArgs;
  }
  
  public Object getOutputArgs() {
    return outputArgs;
  }
  public void setOutputArgs(Object outputArgs) {
    this.outputArgs = outputArgs;
  }
  public Date getStartTime() {
    return startTime;
  }
  public void setStartTime(Date startTime) {
    this.startTime = startTime;
  }
  public Date getEndTime() {
    return endTime;
  }
  public void setEndTime(Date endTime) {
    this.endTime = endTime;
  }
  public long getDuration() {
    return duration;
  }
  public void setDuration(long duration) {
    this.duration = duration;
  }
  public String getExceptionMessage() {
    return exceptionMessage;
  }
  public void setExceptionMessage(String exceptionMessage) {
    this.exceptionMessage = exceptionMessage;
  }
  
  
}
