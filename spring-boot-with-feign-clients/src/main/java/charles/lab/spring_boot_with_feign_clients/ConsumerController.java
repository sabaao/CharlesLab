package charles.lab.spring_boot_with_feign_clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    private BookClient client;

    @GetMapping(value = "/bookavailable")
    public String getBookAvailable() {
        return client.available();
    }
}
