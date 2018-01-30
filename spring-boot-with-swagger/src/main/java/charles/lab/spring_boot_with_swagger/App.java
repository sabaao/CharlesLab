package charles.lab.spring_boot_with_swagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableDiscoveryClient
public class App {
	@RequestMapping(value = "/available", method =RequestMethod.GET )
	public String available() {
		return "Spring in Action";
	}

	@RequestMapping(value = "/checked-out", method =RequestMethod.GET)
	public String checkedOut() {
		return "Spring Boot in Action";
	}

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
