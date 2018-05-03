package com.ch.myr.utils.aop.services;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 操作靜態及動態 scan name
 * @author Charles
 *
 */
@Service
public class ScanServiceImpl implements ScanService{
  
  /**
   * 分隔符號
   */
  private final static String SPLIT_SYMBOL = ",";
  
  @Autowired
  private ConfigService configService;
  
  /**
   * 靜態掃描package set
   */
  private Set<String> staticScanNamesSet;
  
  /**
   * 動態掃描package set
   */
  private Set<String> dynamicScanNamesSet = new HashSet<String>();
  
  @PostConstruct
  public void init() {
    // convert staticScanPackages to set
    staticScanNamesSet = new HashSet<String>(Arrays.asList(configService.getStaticScanNames().split(SPLIT_SYMBOL)));
  }

  @Override
  public Set<String> getStaticNames() {
    return staticScanNamesSet;
  }

  @Override
  public Set<String> getDynamicNames() {
    return dynamicScanNamesSet;
  }

  @Override
  public boolean insertDynamicNames(List<String> names) {
    dynamicScanNamesSet.addAll(names);
    return true;
  }

  @Override
  public boolean deleteDynamicNames(List<String> names) {
    dynamicScanNamesSet.removeAll(names);
    return true;
  }

  @Override
  public boolean isInScanNames(String packageName) {
    long staticCount = staticScanNamesSet.stream().filter(s -> packageName.startsWith(s) && s.isEmpty()==false).count();
    long dynamicCount = dynamicScanNamesSet.stream().filter(s -> packageName.startsWith(s) && s.isEmpty()==false).count();
    
    return (staticCount + dynamicCount) > 0 ? true : false;
  }
}
