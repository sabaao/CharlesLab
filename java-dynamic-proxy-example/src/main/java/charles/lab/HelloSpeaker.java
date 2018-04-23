package charles.lab;

public class HelloSpeaker implements IHello {

  @Override
  public void hello(String name) {
    System.out.println("hello, " + name);

  }

}
