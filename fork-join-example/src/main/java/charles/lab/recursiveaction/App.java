package charles.lab.recursiveaction;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

public class App {
  static final int SIZE = 10_000_000;
  static int[] array = randomArray();
  
  public static void main(String[] args) {
    int number = 9;
    System.out.println("First 10 elements of the array before: ");
    print();
    ArrayTransform mainTask = new ArrayTransform(array, number, 0, SIZE);
    ForkJoinPool pool = new ForkJoinPool();
    pool.invoke(mainTask);
    System.out.println("Fist 10 elements of the array after: ");
    print();
  }

  private static int[] randomArray() {
    int[] array = new int[SIZE];
    Random random = new Random();
    IntStream.range(0, SIZE).forEach(i->{
      array[i] = random.nextInt(100);
    });
    return array;
  }
  
  private static void print() {
    IntStream.range(0, 9).forEach(i->{
      System.out.println(array[i] + ", ");
    });
    System.out.println();
  }
}
