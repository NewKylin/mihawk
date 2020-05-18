package pirate.mihawk;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import pirate.mihawk.pojo.RedisServerInfo;
import pirate.mihawk.pojo.User;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @program: mihawk
 * @description: Redis测试类
 * @author: buck
 * @create: 2020-05-14 21:56
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
    @Autowired
    private RedisTemplate<String, String> strRedisTemplate;
    @Autowired
    private RedisTemplate<String, Serializable> serializableRedisTemplate;
    @Autowired
    private RedisClient redisClient;

    @Test
    public void testString() {
        strRedisTemplate.opsForValue().set("strKey", "zwqh");
        System.out.println(strRedisTemplate.opsForValue().get("strKey"));
    }

    @Test
    public void testSerializable() {
        User user = new User();
        user.setId(1L);
        user.setUserName("朝雾轻寒");
        user.setUserSex("男");
        for (int i = 0; i < 10000; i++) {

            serializableRedisTemplate.opsForValue().set("user" + i, user);
/*            User user2 = (User) serializableRedisTemplate.opsForValue().get("user");
            System.out.println("user:" + user2.getId() + "," + user2.getUserName() + "," + user2.getUserSex());*/
        }
    }

    @Test
    public void  testInfo(){
        StatefulRedisConnection<String, String> connection = redisClient.connect();

        System.out.println("Connected to Redis");

        RedisCommands<String, String> sync = connection.sync();

        String info = sync.info("memory");
        String[] split = info.split("\r\n");
        HashMap<String, String> memoryInfoMap = new HashMap<>();
        for (String s : split){
            String[] split1 = s.split(":");
            if(split1.length>1){
                memoryInfoMap.put(split1[0],split1[1]);
            }
        }
        System.out.println(info);
        connection.close();
        redisClient.shutdown();
    }
}
