package com.ch.myr.utils.aop.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 取得application.yml的Service
 * @author Charles
 *
 */
@Service
public class ConfigService {
  
  /**
   * 靜態掃描package，預設值為空白
   */
  @Value("${aop-log-utils.scan.names:}")
  private String staticScanNames;

  public String getStaticScanNames() {
    return staticScanNames;
  }

  public void setStaticScanNames(String staticScanNames) {
    this.staticScanNames = staticScanNames;
  }
  
  
}
