package charles.lab.spring_boot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @RequestMapping("/users")
  public @ResponseBody String getUsers() {
    return "{\"users\":[{\"firstname\":\"Richard\", \"lastname\":\"Feynman\"}," +
        "{\"firstname\":\"Marie\",\"lastname\":\"Curie\"}]}";
  }
}
