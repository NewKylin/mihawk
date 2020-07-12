package pirate.mihawk.service;

import java.util.concurrent.CompletableFuture;

/**
 * @program: mihawk
 * @description: Redis命令对象
 * @author: buck
 * @create: 2020-07-12 15:51
 **/
public class RedisCommand {

    private String redisCommand;
    private CompletableFuture<Object> completableFuture;

    public RedisCommand(String redisCommand){
        this.redisCommand = redisCommand;
        this.completableFuture = new CompletableFuture<>();
    }

    public CompletableFuture<Object> getCompletableFuture() {
        return completableFuture;
    }

    public void setCompletableFuture(CompletableFuture<Object> completableFuture) {
        this.completableFuture = completableFuture;
    }

    public String getRedisCommand() {
        return redisCommand;
    }

    public void setRedisCommand(String redisCommand) {
        this.redisCommand = redisCommand;
    }
}
