package pirate.mihawk;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import jdk.nashorn.internal.ir.ReturnNode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.io.Serializable;

/**
 * @program: mihawk
 * @description: LettuceRedis配置
 * @author: buck
 * @create: 2020-05-14 21:51
 **/
@Configuration
public class LettuceRedisConfig {

    @Bean
    public RedisTemplate<String, Serializable> redisTemplate(LettuceConnectionFactory factory){
        RedisTemplate<String, Serializable> redisTemplate = new RedisTemplate<>();
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplate.setConnectionFactory(factory);
        return redisTemplate;
    }

    @Bean
    public RedisClient redisClient(){
        return RedisClient.create(RedisURI.create("redis://192.168.177.131:6379"));
    }

    @Bean
    public StatefulRedisConnection<String, String> getStatefulRedisConnection(){
        StatefulRedisConnection<String, String> connection = redisClient().connect();
        return connection;
    }
}
