package charles.lab.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.querydsl.core.annotations.QueryExclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ToString
@NoArgsConstructor
// this will exclude the querysdl from scanning the JPA entity
@QueryExclude

@Entity
@Table(name = "admin")
@Data
public class Admin {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "admin_id")
  private Long id;
  
  @Column(name = "username")
  private String username;
  
  @Column(name = "email")
  private String email;
}
