package pirate.mihawk.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pirate.mihawk.service.RedisClient;

/**
 * @program: mihawk
 * @description: Redis客户端控制器
 * @author: buck
 * @create: 2020-07-07 10:47
 **/

@RestController
@RequestMapping("/RedisClient")
public class RedisClientController {

    @RequestMapping("/command")
    public Object command(String command){
        RedisClient redisClient = RedisClient.getRedisClient("192.168.177.131", 6379);
        Object o = redisClient.sendCommand(command);
        return o;
    }
}
