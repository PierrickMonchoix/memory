package com.pierrickmonchoix.memoryserver.websocketServer;

import java.io.IOException;

import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import com.pierrickmonchoix.memoryserver.websocketMessage.WebsocketMessage;
import com.pierrickmonchoix.memoryserver.websocketMessage.WebsocketMessageDecoder;
import com.pierrickmonchoix.memoryserver.websocketMessage.WebsocketMessageEncoder;


/**
 * @author Mickael BARON (baron.mickael@gmail.com)
 */
@ServerEndpoint(value = "/chat/{username}" , encoders = WebsocketMessageEncoder.class, decoders = WebsocketMessageDecoder.class)
public class WebsocketServerEndpoint {

	@OnOpen
	public void onOpen(Session session, @PathParam("chatroom") String chatRoom, @PathParam("username") String userName)
			throws IOException {
		System.out.println("ChatEndpoint.onOpen()");

	}

	@OnMessage
	public void onMessage(WebsocketMessage message, Session session) {

		System.out.println("### le server recoit et envoie  : ");

        System.out.println(message);

        try {
            session.getBasicRemote().sendObject(message);
        } catch (IOException | EncodeException e) {
            System.out.println("### envoie impossible");
            e.printStackTrace();
        }
        


	}

	@OnClose
	public void onClose(Session session) {
		System.out.println("ChatEndpoint.onClose()");

	}


}
