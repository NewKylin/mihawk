package pirate.mihawk.service;

import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: mihawk
 * @description: Redis内存管理
 * @author: buck
 * @create: 2020-05-18 21:07
 **/
@Service
public class RedisMemoryService {

    @Autowired
    private StatefulRedisConnection<String, String> connection;

    public Map<String,String> getRedisMemoryInfo(){
        RedisCommands<String, String> redisCommands = connection.sync();
        String memory = redisCommands.info("memory");
        String[] split = memory.split("\r\n");
        HashMap<String, String> memoryInfoMap = new HashMap<>();
        for (String s : split){
            String[] split1 = s.split(":");
            if(split1.length>1){
                memoryInfoMap.put(split1[0],split1[1]);
            }
        }
        return memoryInfoMap;
    }
}
