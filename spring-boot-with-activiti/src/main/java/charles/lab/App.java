package charles.lab;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import charles.lab.services.ActivitiService;


@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
	@Bean
	  public CommandLineRunner init(final ActivitiService service) {

	      return new CommandLineRunner() {
	          public void run(String... strings) throws Exception {
	            service.createPersons();
	          }
	      };

	  }
}
