package com.ydhl.mp.handler;

import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.ydhl.mp.model.CommonResponse;
import com.ydhl.mp.model.request.Request;

@Sharable
public class RequestDecoder extends MessageToMessageDecoder<String> {

	private static final InternalLogger LOGGER = InternalLoggerFactory.getInstance(RequestDecoder.class);
	private RequestParser parser = new RequestParser();
	
	@Override
	protected void decode(ChannelHandlerContext ctx, String msg, List<Object> out) throws Exception {
		try {
			LOGGER.info("receive request:"+ msg);
			JSONObject json = new JSONObject(msg);
			Request request = parser.process(json);
			if(request!=null) {
				out.add(request);
			} else {
				CommonResponse res = new CommonResponse(3, "unknow request code");
				ctx.writeAndFlush(res.toString()).addListener(ChannelFutureListener.CLOSE);
			}
		} catch (JSONException e) {
			CommonResponse res = new CommonResponse(1, "not a valid json");
			res.setDescription(e.getMessage());
			ctx.writeAndFlush(res.toString()).addListener(ChannelFutureListener.CLOSE);
		} catch (RuntimeException e) {
			CommonResponse res = new CommonResponse(2, "request json not contain a code property");
			res.setDescription(e.getMessage());
			ctx.writeAndFlush(res.toString()).addListener(ChannelFutureListener.CLOSE);
		}
	}
	
}
