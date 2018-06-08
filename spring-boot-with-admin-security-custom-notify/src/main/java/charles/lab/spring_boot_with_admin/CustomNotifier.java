package charles.lab.spring_boot_with_admin;

import java.util.Arrays;
import java.util.List;
import org.springframework.expression.Expression;
import org.springframework.expression.ParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Component;
import de.codecentric.boot.admin.event.ClientApplicationEvent;
import de.codecentric.boot.admin.event.ClientApplicationRegisteredEvent;
import de.codecentric.boot.admin.event.ClientApplicationStatusChangedEvent;
import de.codecentric.boot.admin.model.StatusInfo;
import de.codecentric.boot.admin.notify.AbstractEventNotifier;

@Component
public class CustomNotifier extends AbstractEventNotifier{
  private final SpelExpressionParser parser = new SpelExpressionParser();
  
  private static final String DEFAULT_MESSAGE = "#{application.name} (#{application.id}) is #{to.status}";
  
  private List<String> notifyStatuses = Arrays.asList("UP", "DOWN", "OFFLINE","UNKNOWN");
  
  private Expression message;
  @Override
  protected void doNotify(ClientApplicationEvent event) throws Exception {
    
    this.message = parser.parseExpression(DEFAULT_MESSAGE, ParserContext.TEMPLATE_EXPRESSION);
    if (event instanceof ClientApplicationRegisteredEvent) {
      //register service
      ClientApplicationRegisteredEvent registeredEvent = (ClientApplicationRegisteredEvent) event;
      System.out.println("this is register, app is " + registeredEvent.getApplication().getName());
    }else if (event instanceof ClientApplicationStatusChangedEvent) {
      //service status changed
      ClientApplicationStatusChangedEvent statusChangedEvent = (ClientApplicationStatusChangedEvent) event;
      String status = statusChangedEvent.getFrom().getStatus();
      
      System.out.println("status is " + status);
      String msg = message.getValue(event, String.class); 
      
      System.out.println("msg is " + msg);
  }
  }

}
