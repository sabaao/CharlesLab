package charles.lab.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.querydsl.core.annotations.QueryExclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Entity
@Table(name = "employee")
@Data
@NoArgsConstructor
public class Employee {
  @Id
  @Column(name = "emp_id")
  private String id;
  
  @Column(name = "emp_name")
  private String name;
  
  @Column(name = "dept_id")
  private String deptId;
  
  @ManyToOne
  @JoinColumn(name="dept_id",insertable=false,updatable=false)
  @JsonIgnore
  private Deptartment dept;
}
