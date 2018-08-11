package charles.lab.repository;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import charles.lab.entities.Deptartment;
import charles.lab.entities.QDeptartment;
import charles.lab.entities.QEmployee;

@Repository
public class DeptRepositoryImpl implements DeptRepository {

  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public List<Deptartment> findByDeptName(String name) {
    QDeptartment dept = QDeptartment.deptartment;
    
    JPAQueryFactory factory = new JPAQueryFactory(entityManager);
    JPAQuery<Deptartment> query = factory.select(dept).from(dept).where(dept.name.eq(name));
    List<Deptartment> result = query.fetch();
    return result;
  }

  @Override
  public List<Deptartment> findByDeptNameAndEmpName(String deptName, String empName) {
    JPAQueryFactory factory = new JPAQueryFactory(entityManager);
    QDeptartment dept = QDeptartment.deptartment;
    QEmployee emp = QEmployee.employee;
    JPAQuery<Deptartment> query = 
        factory.select(dept).from(dept)
          .innerJoin(emp);
    
    Optional<String> deptOpt = Optional.ofNullable(deptName);
    if(deptOpt.isPresent()) {
      query.where(dept.name.eq(deptOpt.get()));
    }
    
    Optional<String> empOpt = Optional.ofNullable(empName);
    if(empOpt.isPresent()) {
      query.where(emp.name.eq(empOpt.get()));
    }
    
    return query.fetch();
  }

}
