package com.ydhl.mp.handler;

import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

import com.ydhl.mp.model.request.Request;

@Sharable
public class BusinessHandler extends SimpleChannelInboundHandler<Request> {
	private static final InternalLogger LOGGER = InternalLoggerFactory.getInstance(RequestDecoder.class);
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, Request msg) throws Exception {
		LOGGER.info("process request:"+msg);
		ctx.write("ok").addListener(ChannelFutureListener.CLOSE);
	}
	
	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		ctx.flush();
	}
	
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
