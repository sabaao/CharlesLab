package charles.lab.parallelism;

import java.util.concurrent.RecursiveTask;

public class ArrayCounter extends RecursiveTask<Integer> {
  private static final long serialVersionUID = 6902455897310013447L;
  
  int[] array;
  int threshold = 100_000;
  int start;
  int end;
  
  public ArrayCounter(int[] array, int start, int end,int threshold) {
    this.array = array;
    this.start = start;
    this.end = end;
    this.threshold = threshold;
  }
  
  @Override
  protected Integer compute() {
    if(end - start < threshold) {
      return computeDirectly();
    }else {
      int middle = (end + start) /2;
      ArrayCounter subTask1 = new ArrayCounter(array, start, middle,threshold);
      ArrayCounter subTask2 = new ArrayCounter(array, middle, end,threshold);
      invokeAll(subTask1,subTask2);
      
      return subTask1.join() + subTask2.join();
    }
  }
  
  protected Integer computeDirectly() {
    Integer count = 0;
    for(int i = start;i<end;i++) {
      if(array[i] % 2 ==0) {
        count ++;
      }
    }
    
    return count;
  }

}
