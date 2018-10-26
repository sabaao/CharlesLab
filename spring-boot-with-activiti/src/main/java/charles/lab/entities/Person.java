package charles.lab.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Person implements Serializable{
  /**
   * 
   */
  private static final long serialVersionUID = 6113806468001385311L;
  @Id
  @GeneratedValue
  private Long id;
  private String name;
  private Date birthday;
  
  public Person(String name,Date birthday) {
    this.name = name;
    this.birthday = birthday;
  }
}
