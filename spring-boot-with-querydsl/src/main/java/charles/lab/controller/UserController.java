package charles.lab.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import charles.lab.entities.Admin;
import charles.lab.entities.User;
import charles.lab.service.UserService;

@RestController
public class UserController {
  
  @Autowired
  private UserService userService;
  
  @RequestMapping(value = "/user")
  public List<User> getUsers(@RequestParam("username") String username, @RequestParam("email") String email){
    List<User> list = userService.findUsersByUsernameAndEmail(username, email);
    return list;
  }
  
  @RequestMapping(value = "/admin")
  public List<Admin> getAdmins(@RequestParam("username") String username, @RequestParam("email") String email){
    return userService.findAdminByUsernameAndEmail(username, email);
  }
}
