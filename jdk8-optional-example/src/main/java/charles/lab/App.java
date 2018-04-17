package charles.lab;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class App {
  private static void nameNotNull() {
    System.out.println("nameNotNull start");
    String name = "tony";
    Optional<String> optName = Optional.of(name);
    System.out.println(optName.get());// tony
    System.out.println("nameNotNull end");
  }

  private static void nameNullable() {
    System.out.println("nameNullable start");
    String name = null;
    Optional<String> optName = Optional.ofNullable(name);
    // System.out.println(optName.get());
    // throw java.util.NoSuchElementException: No value present
    System.out.println("nameNullable end");

  }

  private static void nameIsPresent() {
    System.out.println("nameIsPresent start");
    String name = null;
    Optional<String> optName = Optional.ofNullable(name);
    if (optName.isPresent()) {
      // optName.isPresent() is same with name!=null

      System.out.println(optName.get());
    } else {
      System.out.println("name is null");
    }
    System.out.println("nameIsPresent end");
  }

  private static void nameOrElse() {
    System.out.println("nameOrElse start");
    String name = null;
    Optional<String> optName = Optional.ofNullable(name);
    System.out.println(optName.orElse("name is null"));
    System.out.println("nameOrElse end");
  }

  private static void nameOrElseGet() {
    System.out.println("nameOrElseGet start");
    String name = null;
    Optional<String> optName = Optional.ofNullable(name);
    System.out.println(optName.orElseGet(() -> "what! null!"));
    System.out.println("nameOrElseGet end");
  }

  private static void nameOrElseThrow() {
    class MyException extends Exception {
      public MyException(String message) {
        super(message);
      }
    }

    System.out.println("nameOrElseThrow start");
    String name = null;
    Optional<String> optName = Optional.ofNullable(name);
    try {
      System.out.println(optName.orElseThrow(() -> new MyException("what!null!")));
    } catch (MyException e) {
      System.out.println("my exception, " + e.getMessage());
    }

    System.out.println("nameOrElseThrow end");
  }

  private static Optional<List<User>> getUsers() {
    List<User> users = Arrays.asList(new User(1, "Tony"), new User(2, "John"), new User(3, "Emma"));
    return Optional.ofNullable(users);
  }

  private static Optional<User> findUserByName(String name) {
    Optional<List<User>> users = getUsers();
    if (users.isPresent() && Optional.ofNullable(name).isPresent()) {
      return users.get().stream().filter(u -> u.name.equals(name)).findFirst();
    } else {
      return Optional.empty();
    }
  }

  public static void main(String[] args) {
    nameNotNull();
    nameNullable();
    nameIsPresent();
    nameOrElse();
    nameOrElseGet();
    nameOrElseThrow();
    
    Optional<User> user = findUserByName("Amy");
    //will not print
    user.ifPresent(u->System.out.println(u.name + " id is " + u.id));
    
    Optional<User> user2 = findUserByName("Tony");
    //will print Tony id is 1
    user2.ifPresent(u->System.out.println(u.name + " id is " + u.id));
  }


}


class User {
  public int id;
  public String name;

  public User(int id, String name) {
    this.id = id;
    this.name = name;
  }
}
