package charles.lab.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import charles.lab.annotation.ApiVersion;

@ApiVersion(2)
@RequestMapping("/{api_version}")
@RestController
public class TestVersionControllerV2 {
  @RequestMapping("/hello")
  public String hello() {
    return "hello v2";
  }
}
