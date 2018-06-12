package charles.lab.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import charles.lab.entities.Admin;
import charles.lab.entities.User;
import charles.lab.repository.AdminRepository;
import charles.lab.repository.UserCustomRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private AdminRepository adminRepository;

  @Autowired
  private UserCustomRepository userCustomRepository;

  @Override
  public List<User> findUsersByUsernameAndEmail(String username, String email) {
    return userCustomRepository.findUserByUsernameAndEmail(username,email);
  }

  @Override
  public List<Admin> findAdminByUsernameAndEmail(String username, String email) {
    return adminRepository.findByUsernameAndEmail(username,email);
  }

}
