package charles.lab.repository;

import java.util.List;
import charles.lab.entities.Deptartment;

public interface DeptRepository {
  List<Deptartment> findByDeptName(String name);
  List<Deptartment> findByDeptNameAndEmpName(String deptName, String empName);
}
