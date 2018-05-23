package charles.lab.spring_boot;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {
  
  private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
  
  @Scheduled(fixedRate=100)
  public void reportCurrentTime() {
    System.out.println("now is " + dateFormat.format(new Date()));
  }
}
