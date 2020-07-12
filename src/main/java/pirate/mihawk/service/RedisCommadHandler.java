package pirate.mihawk.service;

import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.CodecException;
import io.netty.handler.codec.redis.*;
import io.netty.util.CharsetUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @program: mihawk
 * @description: Redis命令处理器
 * @author: buck
 * @create: 2020-07-06 21:44
 **/
public class RedisCommadHandler extends ChannelDuplexHandler {
    CompletableFuture<Object> completableFuture;
    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        RedisCommand commandObj = (RedisCommand)msg;
        if(commandObj == null)
            return;
        completableFuture = commandObj.getCompletableFuture();
        String[] commands = commandObj.getRedisCommand().split("\\s+");
        List<RedisMessage> children = new ArrayList<>(commands.length);
        for (String cmdString : commands) {
            children.add(new FullBulkStringRedisMessage(ByteBufUtil.writeUtf8(ctx.alloc(), cmdString)));
        }
        RedisMessage request = new ArrayRedisMessage(children);
        ctx.write(request, promise);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        RedisMessage redisMessage = (RedisMessage) msg;
        completableFuture.complete(getRedisResponse(redisMessage));
    }
    private String getRedisResponse(RedisMessage msg) {
        String redisMessage = "";
        if (msg instanceof SimpleStringRedisMessage) {
            redisMessage += ((SimpleStringRedisMessage) msg).content() +"\n";
        } else if (msg instanceof ErrorRedisMessage) {
            redisMessage += ((ErrorRedisMessage) msg).content() +"\n";;
        } else if (msg instanceof IntegerRedisMessage) {
            redisMessage += ((IntegerRedisMessage) msg).value() +"\n";
        } else if (msg instanceof FullBulkStringRedisMessage) {
            redisMessage += getString((FullBulkStringRedisMessage) msg) +"\n";
        } else if (msg instanceof ArrayRedisMessage) {
            for (RedisMessage child : ((ArrayRedisMessage) msg).children()) {
                redisMessage += getRedisResponse(child) +"\n";
            }
        } else {
            throw new CodecException("unknown message type: " + msg);
        }
        return redisMessage;
    }
    private static String getString(FullBulkStringRedisMessage msg) {
        if (msg.isNull()) {
            return "(null)";
        }
        return msg.content().toString(CharsetUtil.UTF_8);
    }
}
