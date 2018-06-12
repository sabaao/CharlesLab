package charles.lab.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import charles.lab.entities.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
  List<Admin> findByUsernameAndEmail(String username,String email);
}
