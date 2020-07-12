package pirate.mihawk.service;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.redis.RedisArrayAggregator;
import io.netty.handler.codec.redis.RedisBulkStringAggregator;
import io.netty.handler.codec.redis.RedisDecoder;
import io.netty.handler.codec.redis.RedisEncoder;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @program: mihawk
 * @description: Redis客户端
 * @author: buck
 * @create: 2020-07-06 21:35
 **/
public class RedisClient {
    private String host;
    private int port;
    private Channel channel;
    private Object result;

    private static RedisClient redisClient;

    public static RedisClient getRedisClient(String host,int port){
        if(redisClient == null)
            redisClient = new RedisClient(host,port);
        return redisClient;
    }

    private RedisClient(String host,int port){
        this.host = host;
        this.port = port;
    }

    public void init(){
        NioEventLoopGroup eventExecutors = new NioEventLoopGroup(1);
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventExecutors).channel(NioSocketChannel.class).handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ChannelPipeline pipeline = ch.pipeline();
                    pipeline.addLast(new RedisDecoder());
                    pipeline.addLast(new RedisEncoder());
                    pipeline.addLast(new RedisBulkStringAggregator());
                    pipeline.addLast(new RedisArrayAggregator());
                    pipeline.addLast(new RedisCommadHandler());
                }
            });
            ChannelFuture sync = bootstrap.connect(host, port).sync();
            channel = sync.channel();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public Channel getChannel(){
        return channel;
    }
    public void setResult(Object result){
        this.result = result;
    }

    public Object sendCommand(String command){
        if(command.isEmpty())
            return null;
        if(getChannel() == null)
            init();
        try {
            RedisCommand redisCommand = new RedisCommand(command);
            ChannelFuture channelFuture = channel.writeAndFlush(redisCommand).addListener(future -> {
                if (!future.isSuccess())
                    setResult("命令执行发生错误");
            }).sync();
            result = redisCommand.getCompletableFuture().get();
        }catch (InterruptedException e){
            e.printStackTrace();
        }catch (ExecutionException e){
            e.printStackTrace();
        }
        return result;
    }
}
