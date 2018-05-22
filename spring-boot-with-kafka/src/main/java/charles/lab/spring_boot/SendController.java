package charles.lab.spring_boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendController {
  @Autowired
  private Sender sender;
  
  @RequestMapping(value = "/send")
  public boolean send() {
    sender.send();
    return true;
  }
}
