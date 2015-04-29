package com.ydhl.mp;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import com.ydhl.mp.handler.BusinessHandler;
import com.ydhl.mp.handler.RequestDecoder;

public class ServerInitializer extends ChannelInitializer<SocketChannel> {
	private static final StringDecoder DECODER = new StringDecoder();
	private static final StringEncoder ENCODER = new StringEncoder();
	private static final RequestDecoder REQUEST = new RequestDecoder();
	
	private static final BusinessHandler SERVER_HANDLER = new BusinessHandler();

	public ServerInitializer() {
		
	}

	@Override
	public void initChannel(SocketChannel ch) throws Exception {
		ChannelPipeline pipeline = ch.pipeline();
		
		pipeline.addLast(new DelimiterBasedFrameDecoder(8192, Delimiters
				.lineDelimiter()));
		pipeline.addLast(DECODER,ENCODER);
		
		pipeline.addLast(REQUEST);
				
		pipeline.addLast(SERVER_HANDLER);
		
	}
}
