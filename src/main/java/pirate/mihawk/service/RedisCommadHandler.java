package pirate.mihawk.service;

import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultChannelPromise;
import io.netty.handler.codec.CodecException;
import io.netty.handler.codec.redis.*;
import io.netty.util.CharsetUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: mihawk
 * @description: Redis命令处理器
 * @author: buck
 * @create: 2020-07-06 21:44
 **/
public class RedisCommadHandler extends ChannelDuplexHandler {
    DefaultChannelPromise channelPromise;
    public RedisCommadHandler(DefaultChannelPromise defaultChannelPromise){
        this.channelPromise = defaultChannelPromise;
    }
    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        String[] commands = ((String) msg).split("\\s+");
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
    }
    private Object getRedisResponse(RedisMessage msg) {
        Object redisMessage = null;
        if (msg instanceof SimpleStringRedisMessage) {
            redisMessage = ((SimpleStringRedisMessage) msg).content();
        } else if (msg instanceof ErrorRedisMessage) {
            redisMessage = ((ErrorRedisMessage) msg).content();
        } else if (msg instanceof IntegerRedisMessage) {
            redisMessage = ((IntegerRedisMessage) msg).value();
        } else if (msg instanceof FullBulkStringRedisMessage) {
            redisMessage = getString((FullBulkStringRedisMessage) msg);
        } else if (msg instanceof ArrayRedisMessage) {
            for (RedisMessage child : ((ArrayRedisMessage) msg).children()) {
                getRedisResponse(child);
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
