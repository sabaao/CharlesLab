package charles.lab.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import charles.lab.entities.Deptartment;
import charles.lab.service.DeptService;

@RestController
@RequestMapping(value = "/dept")
public class DeptController {
  
  @Autowired
  private DeptService deptService;
  
  @RequestMapping(value = "/deptname")
  public List<Deptartment> getDepts(@RequestParam("deptname") String deptName){
    return deptService.findByDeptName(deptName);
  }
  
  @RequestMapping(value = "/dyanmicquery")
  public List<Deptartment> getDepts(@RequestParam("deptname") String deptName, @RequestParam("empName") String empName){
    return deptService.findByDeptNameAndEmpName(deptName, empName);
  }
}
