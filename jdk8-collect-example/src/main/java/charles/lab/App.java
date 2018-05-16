package charles.lab;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

  public static void main(String[] args) {
    List<String> collected = Stream.of("a","b","c").collect(Collectors.toList());
    collected.stream().forEach(System.out::println);
        
  }


}
