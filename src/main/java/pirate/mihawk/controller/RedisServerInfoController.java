package pirate.mihawk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pirate.mihawk.service.RedisMemoryService;

import java.util.Map;

/**
 * @program: mihawk
 * @description: Redis服务控制器
 * @author: buck
 * @create: 2020-05-18 21:21
 **/

@RestController
@RequestMapping("/RedisServerInfo")
public class RedisServerInfoController {

    @Autowired
    private RedisMemoryService memoryService;

    @RequestMapping("/memory")
    public Map<String,String> memory(){
        Map<String, String> redisMemoryInfo = memoryService.getRedisMemoryInfo();

        return redisMemoryInfo;
    }
}
