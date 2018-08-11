package charles.lab.service;

import java.util.List;
import charles.lab.entities.Admin;
import charles.lab.entities.Deptartment;
import charles.lab.entities.Employee;
import charles.lab.entities.User;

public interface DeptService {
  List<Deptartment> findByDeptName(String name);

  List<Deptartment> findByDeptNameAndEmpName(String deptName, String empName);
}
