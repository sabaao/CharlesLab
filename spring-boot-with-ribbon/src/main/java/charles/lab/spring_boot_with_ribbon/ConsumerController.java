package charles.lab.spring_boot_with_ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/bookavailable")
    public String getBookAvailable() {
        return restTemplate.getForEntity("http://book/available", String.class).getBody();
    }
}
