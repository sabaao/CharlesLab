package charles.lab.spring_boot_with_config_server;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@EnableDiscoveryClient
public class App {
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
	
}

@RefreshScope
@RestController
class RestControl{
	@Value("${charles.lab.value}")
	private String value;
	
	@RequestMapping(value = "/charleslab")
	public String getCharlesLabValue() {
		return value;
	}
}
