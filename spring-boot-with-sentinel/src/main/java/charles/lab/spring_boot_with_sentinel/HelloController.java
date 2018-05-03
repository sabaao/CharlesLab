package charles.lab.spring_boot_with_sentinel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
  @Autowired
  RedisTemplate redisTemplate;

  @Autowired
  StringRedisTemplate stringRedisTemplate;

  @RequestMapping("/set")
  public void set() {
    redisTemplate.opsForValue().set("test", "4321");
  }
  
  @RequestMapping("/getvalue")
  public String getValue(){
    return redisTemplate.opsForValue().get("test").toString();
  }

  @RequestMapping("/show")
  public String show() {
    return "Hello World";
  }
}
