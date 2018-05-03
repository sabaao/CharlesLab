package com.ch.myr.utils.aop.services;

import java.util.List;
import java.util.Set;

/**
 * 提供動態及靜態package掃描清單操作
 * @author Charles
 *
 */
public interface ScanService {
  
  /**
   * 取得靜態掃描package清單
   * @return
   */
  public Set<String> getStaticNames();
  
  
  /**
   * 取得動態掃描packages清單
   * @return
   */
  public Set<String> getDynamicNames();
  
  /**
   * 新增動態掃描packages清單
   * @param names
   * @return
   */
  public boolean insertDynamicNames(List<String> names);
  
  /**
   * 刪除動態掃描packages清單
   * @param names
   * @return
   */
  public boolean deleteDynamicNames(List<String> names);
  
  /**
   * 是否在動態或靜態的掃描清單中
   * true : 存在在清單中
   * false : 不存在在清單中
   * @param packageName
   * @return
   */
  public boolean isInScanNames(String packageName);
}