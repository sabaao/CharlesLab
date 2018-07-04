package charles.lab;

import redis.clients.jedis.Jedis;

public class App {

  public App() {}

  public static void main(String[] args) throws InterruptedException {
    Jedis jedis = new Jedis("127.0.0.1", 6379);
    System.out.println("connection success");
    
    //check server is running
    System.out.println("server is running : " + jedis.ping());
    
    //set value to redis
    jedis.set("charles", "value");
    
    //get value
    System.out.println("charles is " + jedis.get("charles"));
    
    //after 5 seconds, it will expired.
    jedis.expire("charles",5);
    
    //set value , if it not exist.
    //if it existed, it will be fail.
    Long result = jedis.setnx("charles_nx", "value_nx");
    
    //setnx result
    System.out.println("setnx result is " + result);
    
    //you also can set expire
    jedis.expire("charles_nx", 5);
    System.out.println("charles_nx is " + jedis.get("charles_nx"));
    
    //set nx value again
    result = jedis.setnx("charles_nx", "value_nx2");
    
    //setnx result
    System.out.println("setnx result is " + result);
    
  //get charles_nx again
    System.out.println("charles_nx is " + jedis.get("charles_nx"));
    
    //sleep 5 seconds
    System.out.println("sleep 6 seconds");
    Thread.sleep(6000);
    
    //get charles_nx again
    System.out.println("charles_nx is " + jedis.get("charles_nx"));
    
    //close
    jedis.close();
    
  }
}
