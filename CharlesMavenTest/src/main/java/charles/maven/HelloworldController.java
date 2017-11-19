package charles.maven;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloworldController {
  @GetMapping("/")
  public String hello() {
    return "Hello world - springboot-appengine-standard!";
  }
}
