package com.pierrickmonchoix.memoryclient.websocket.websocketMessage;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

import com.google.gson.Gson;

public class WebsocketMessageDecoder implements Decoder.Text<WebsocketMessage> {

	private static Gson gson = new Gson();
	
	@Override
	public void init(EndpointConfig config) {
		// TODO Auto-generated method stub
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public WebsocketMessage decode(String mess) throws DecodeException {
		return gson.fromJson(mess, WebsocketMessage.class);
	}

	@Override
	public boolean willDecode(String mess) {
		// TODO Auto-generated method stub
		return true;
	}

}
