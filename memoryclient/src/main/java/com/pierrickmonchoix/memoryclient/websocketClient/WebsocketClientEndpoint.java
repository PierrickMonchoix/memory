package com.pierrickmonchoix.memoryclient.websocketClient;

import java.io.IOException;

import javax.websocket.ClientEndpoint;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

import com.pierrickmonchoix.memoryclient.websocketMessage.WebsocketMessage;
import com.pierrickmonchoix.memoryclient.websocketMessage.WebsocketMessageDecoder;
import com.pierrickmonchoix.memoryclient.websocketMessage.WebsocketMessageEncoder;



/**
 * @author Mickael BARON (baron.mickael@gmail.com)
 */
@ClientEndpoint( encoders = WebsocketMessageEncoder.class, decoders = WebsocketMessageDecoder.class)
public class WebsocketClientEndpoint {


	public WebsocketClientEndpoint() {
	}

	@OnOpen
	public void onOpen(Session session) throws IOException {
		System.out.println("ChatClientEndpoint.onOpen()");
	}

	@OnMessage
	public void onMessage(WebsocketMessage message) {
		System.out.println("Le clien recoit  : ");

		System.out.println("Received by client : " + message);
	}
}
