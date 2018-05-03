package charles.lab.java_use_sentinel;

import java.net.Socket;
import java.util.HashSet;
import java.util.Set;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;
import redis.clients.jedis.exceptions.JedisException;

/**
 * Hello world!
 *
 */
public class App {
  private static final String MASTER_NAME = "master";
  public static final String PASSWORD = "foobared";
  private static final Set sentinels;
  static {
    sentinels = new HashSet();
    sentinels.add("localhost:26379");
    sentinels.add("localhost:26380");
  }

  public App() {}

  public void runTestData() throws InterruptedException {
    boolean writeNext = true;
    JedisSentinelPool pool = new JedisSentinelPool(MASTER_NAME, sentinels);
    Jedis jedis = null;
    while (true) {
        try {
            System.out.println("Fetching connection from pool");
            jedis = pool.getResource();
            System.out.println("Authenticating...");
//            jedis.auth(PASSWORD);
            System.out.println("auth complete...");
            Socket socket = jedis.getClient().getSocket();
            System.out.println("Connected to " + socket.getRemoteSocketAddress());
            while (true) {
                if (writeNext) {
                  System.out.println("Writing...");
                    jedis.set("java-key-999", "java-value-999");
                    writeNext = false;
                } else {
                  System.out.println("Reading...");
                    jedis.get("java-key-999");
                    writeNext = true;
                }
                Thread.sleep(2 * 1000);
            }
        } catch (JedisException e) {
          System.out.println("Connection error of some sort!");
          System.out.println(e.getMessage());
            Thread.sleep(2 * 1000);
        } catch(Exception e){
          e.printStackTrace();
        }
        finally {
            if (jedis != null) {
              try{
                jedis.close();
              }catch(Exception e){
                e.printStackTrace();
              }
                
            }
        }
    }
  }

  public static void main(String[] args) throws InterruptedException {
    App app = new App();
    app.runTestData();
  }
}
