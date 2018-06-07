package charles.lab.spring_boot_with_admin_client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
public class App {
  private Logger logger = LoggerFactory.getLogger(this.getClass());
  
  @RequestMapping(value="/writeinfo")
  public String writeInfo() {
    logger.info("here is info");
    return "success";
  }
  
  @RequestMapping(value="/writeerror")
  public String writeError() {
    logger.error("here is error");
    return "success";
  }
    
	@RequestMapping(value = "/available")
	public String available() {
		return "Spring in Action";
	}

	@RequestMapping(value = "/checked-out")
	public String checkedOut() {
		return "Spring Boot in Action";
	}

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
