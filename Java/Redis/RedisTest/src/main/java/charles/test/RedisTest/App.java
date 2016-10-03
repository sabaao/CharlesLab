package charles.test.RedisTest;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import redis.clients.jedis.Jedis;

public class App {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// 連結Redis服務
		Jedis jedis = new Jedis("localhost");
		System.out.println("Connection to server sucessfully");
		// 服務是否運行
		System.out.println("Server is running: " + jedis.ping());

		// key-value 儲存
		jedis.set("runoobkey", "Redis tutorial");

		// 取出數據並輸出
		System.out
				.println("Stored string in redis:: " + jedis.get("runoobkey"));

		// append字串在原有字串
		jedis.append("runoobkey", "runoobkey append");

		System.out
				.println("Append string in redis:: " + jedis.get("runoobkey"));

		// mset設置多組key-value
		jedis.mset("name1", "value1", "name2", "value2", "name3", "value3");

		// mget取得多組key-value
		List<String> list = jedis.mget("name1", "name2", "name3");
		System.out.println("This is mget value:" + list);

		// map
		Map<String, String> user = new HashMap<String, String>();
		user.put("charles", "charles-Value");
		user.put("John", "John-Value");
		user.put("Tom", "Tom-Value");

		// jedis存入map
		jedis.hmset("user", user);

		// map取出key的數目
		System.out.println("user len:" + jedis.hlen("user"));

		// map中所有的key
		System.out.println("user keys:" + jedis.hkeys("user"));

		// map中所有的value
		System.out.println("user vales:" + jedis.hvals("user"));

		List<String> userList = jedis.hmget("user", "charles", "John");
		// 取得map中的多個value
		System.out.println(userList);

		// 刪除map 中一個key
		jedis.hdel("user", "charles");

		// 印出被刪除的value
		System.out.println("this deleted:" + jedis.hmget("user", "charles"));

		// list
		jedis.del("listDemo");
		System.out.println("listDemo is :" + jedis.lrange("listDemo", 0, -1));
		jedis.lpush("listDemo", "A");
		jedis.lpush("listDemo", "B");
		jedis.lpush("listDemo", "C");
		System.out.println(jedis.lrange("listDemo", 0, -1));
		System.out.println(jedis.lrange("listDemo", 0, 1));

		// set
		jedis.sadd("sname", "wobby");
		jedis.sadd("sname", "kings");
		jedis.sadd("sname", "demon");
		System.out.println(String.format("set num: %d", jedis.scard("sname")));
		System.out.println(String.format("all members: %s",
				jedis.smembers("sname")));
		System.out.println(String.format("is member: %B",
				jedis.sismember("sname", "wobby")));
		System.out.println(String.format("rand member: %s",
				jedis.srandmember("sname")));
		// 删除一个对象
		jedis.srem("sname", "demon");
		System.out.println(String.format("all members: %s",
				jedis.smembers("sname")));
		
		// 下面是对对象进行存储的测试代码
        ByteArrayOutputStream bos =  new ByteArrayOutputStream();
        ObjectOutputStream oos =  new ObjectOutputStream(bos);
        
        Person person =  new Person("liudehua" ,22);
        oos.writeObject(person);
         byte[] byteArray = bos.toByteArray();
        oos.close();
        bos.close();
        String setObjectRet = jedis.set("mingyuan".getBytes(), byteArray);
        System.out.println(" set object return \t" + setObjectRet);
 
         byte[] bs = jedis.get("mingyuan".getBytes());
 
        ByteArrayInputStream bis =  new ByteArrayInputStream(bs);
        ObjectInputStream inputStream =  new ObjectInputStream(bis);
        Person readObject = (Person) inputStream.readObject();
        System.out.println(" read object \t" + readObject.toString());
        inputStream.close();
        bis.close();
 
        jedis.disconnect();
	}
}
