package charles.lab.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import charles.lab.entities.Deptartment;
import charles.lab.repository.DeptRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DeptServiceImpl implements DeptService {

  @Autowired
  private DeptRepository deptRepository;

  @Override
  public List<Deptartment> findByDeptName(String name) {
    return deptRepository.findByDeptName(name);
  }

  @Override
  public List<Deptartment> findByDeptNameAndEmpName(String deptName, String empName) {
    return deptRepository.findByDeptNameAndEmpName(deptName, empName);
  }

}
