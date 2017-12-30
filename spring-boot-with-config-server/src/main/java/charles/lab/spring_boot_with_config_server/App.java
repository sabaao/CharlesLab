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
	@Value("${charles.didispace.value}")
	private String didispace;
	
	@Value("${charles.didispace.dev.value}")
	private String didispaceDev;
	
	@Value("${charles.base.value}")
	private String base;
	
	@Value("${common.base.value}")
	private String common;
	
	@RequestMapping(value = "/didispace")
	public String getDidiSpaceValue() {
		return didispace;
	}
	
	@RequestMapping(value = "/didispacedev")
	public String getDidiSpaceDevValue() {
		return didispaceDev;
	}
	
	@RequestMapping(value = "/base")
	public String getBase() {
		return base;
	}
	
	@RequestMapping(value = "/common")
	public String getCommon() {
		return common;
	}
}
