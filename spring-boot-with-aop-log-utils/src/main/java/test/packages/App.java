package test.packages;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"test.packages","com.cathay.holdings","com.cathay.bank","com.ch.myr"})
public class App {
  public static void main(String[] args) {
    SpringApplication.run(App.class, args);
  }
}
