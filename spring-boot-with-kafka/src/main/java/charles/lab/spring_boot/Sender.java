package charles.lab.spring_boot;


import java.util.Date;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Component

public class Sender {
  private final static Logger logger = LoggerFactory.getLogger(Sender.class);
  
  private Gson gson = new GsonBuilder().create();
  
  @Autowired
  private KafkaTemplate<String, String> kafkaTemplate;
  
  public void send() {
    Message message = new Message();
    message.setId(System.currentTimeMillis());
    message.setMsg(UUID.randomUUID().toString());
    message.setSendDate(new Date());
    logger.info("+++++++++++++++++++++  message = {}", gson.toJson(message));
    kafkaTemplate.send("charles", gson.toJson(message));
  }
}
