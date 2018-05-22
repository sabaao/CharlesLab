package charles.lab.spring_boot;

import java.util.Optional;
import java.util.concurrent.CountDownLatch;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {
  private static final Logger logger = LoggerFactory.getLogger(Receiver.class);
  
  @KafkaListener(topics = {"charles"})
  public void receive(ConsumerRecord<?, ?> record) {
    Optional<?> kafkaMessage = Optional.ofNullable(record.value());

    if (kafkaMessage.isPresent()) {

        Object message = kafkaMessage.get();

        logger.info("----------------- record =" + record);
        logger.info("------------------ message =" + message);
    }
  }
}
