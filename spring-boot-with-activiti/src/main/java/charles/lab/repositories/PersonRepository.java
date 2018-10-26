package charles.lab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import charles.lab.entities.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{
  public Person findByName(String name);
}
