package charles.lab.spring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
@EnableScheduling
public class App {
	@RequestMapping(value = "/available")
	public String available() {
		return "Spring in Action";
	}

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
