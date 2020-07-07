package pirate.mihawk.service;

public class RedisClientInstanst {
    private static RedisClientInstanst ourInstance = new RedisClientInstanst();

    public static RedisClientInstanst getInstance() {
        return ourInstance;
    }

    private RedisClientInstanst() {
    }
}
