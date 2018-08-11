package charles.lab.entities;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.querydsl.core.annotations.QueryExclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Entity
@Table(name = "deptartment")
@Data
@NoArgsConstructor
public class Deptartment {
  @Id
  @Column(name = "dept_Id")
  private String id;
  
  @Column(name = "dept_Name")
  private String name;
  
  @OneToMany(mappedBy = "dept",fetch = FetchType.EAGER)
  private List<Employee> empList;
}
