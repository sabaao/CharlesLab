package charles.lab.service;

import java.util.List;
import charles.lab.entities.Admin;
import charles.lab.entities.User;

public interface UserService {
  List<User> findUsersByUsernameAndEmail(String username, String email);

  List<Admin> findAdminByUsernameAndEmail(String username, String email);
}
