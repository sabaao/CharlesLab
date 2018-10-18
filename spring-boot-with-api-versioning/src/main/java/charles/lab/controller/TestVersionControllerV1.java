package charles.lab.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import charles.lab.annotation.ApiVersion;

@ApiVersion(1)
@RequestMapping("/{api_version}")
@RestController
public class TestVersionControllerV1 {
  @RequestMapping("/hello")
  public String hello() {
    return "hello v1";
  }
}
