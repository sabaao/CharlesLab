package hello;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() throws InterruptedException {
        log.info("The time is now {}", dateFormat.format(new Date()));
//        for(;;){
//        	
//        }
        //Thread.sleep(5000);
    }
    
    
    @Scheduled(fixedRate = 1000)
    public void reportEverySecond() {
        log.info("reportEverySecond , The time is now {}", dateFormat.format(new Date()));
        for(;;){
        	
        }
    }
}
