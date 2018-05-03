package com.ch.myr.utils.aop.controllers;

import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.ch.myr.utils.aop.services.ScanService;

@RestController
@RequestMapping("/aop")
public class AopController {
  
  @Autowired
  private ScanService scanService;
  /**
   * 取得靜態掃描package清單
   * @return
   */
  @RequestMapping(value="/static/list",method=RequestMethod.GET)
  @ResponseBody
  public Set<String> getStaticNames() {
    //TODO
    //change myr json response
    return scanService.getStaticNames();
  }
  
  /**
   * 取得動態掃描packages清單
   * @return
   */
  @RequestMapping(value="/dynamic/list",method=RequestMethod.GET)
  @ResponseBody
  public Set<String> getDynamicNames() {
    //TODO
    //change myr json response
    return scanService.getDynamicNames();
  }
  
  /**
   * 新增動態掃描packages清單
   * @param names
   * @return
   */
  @ResponseBody
  @RequestMapping(value="/dynamic/list",method=RequestMethod.POST)
  public boolean insertDynamicNames(@RequestBody List<String> names) {
    //change myr json response
    return scanService.insertDynamicNames(names);
  }
  
  /**
   * 刪除動態掃描packages清單
   * @param names
   * @return
   */
  @ResponseBody
  @RequestMapping(value="/dynamic/list",method=RequestMethod.DELETE)
  public boolean deleteDynamicNames(@RequestBody List<String> names) {
    //change myr json response
    return scanService.deleteDynamicNames(names);
  }
  
}
