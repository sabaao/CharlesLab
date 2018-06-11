package charles.lab.spring_boot_with_actuator;

import java.util.Collection;
import org.springframework.boot.actuate.endpoint.PublicMetrics;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.prometheus.client.exporter.MetricsServlet;
import io.prometheus.client.hotspot.DefaultExports;

@Configuration
public class Config {
  @Bean
  public SpringBootMetricsCollector springBootMetricsCollector(Collection<PublicMetrics> publicMetrics) {
      SpringBootMetricsCollector springBootMetricsCollector = new SpringBootMetricsCollector(publicMetrics);
      springBootMetricsCollector.register();
      return springBootMetricsCollector;
  }

  @Bean
  public ServletRegistrationBean servletRegistrationBean() {
      DefaultExports.initialize();
      return new ServletRegistrationBean(new MetricsServlet(), "/prometheus");
  }
}
