package charles.lab.spring_boot_with_feign_clients;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients 
@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class);
	}
}
