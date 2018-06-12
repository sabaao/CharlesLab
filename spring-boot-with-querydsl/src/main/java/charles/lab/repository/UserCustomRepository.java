package charles.lab.repository;

import java.util.List;
import charles.lab.entities.User;

public interface UserCustomRepository {
  List<User> findUserByUsernameAndEmail(String username, String email);
}
