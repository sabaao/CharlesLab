package charles.lab.spring_boot_with_feign_clients;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("BOOK")
public interface BookClient {
	
	@RequestMapping(method=RequestMethod.GET, value="/available")
	String available();
}
