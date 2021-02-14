package com.pierrickmonchoix.memoryserver.websocketServer;

import java.io.IOException;

import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import com.pierrickmonchoix.memoryserver.websocketServer.websocketMessage.WebsocketMessage;
import com.pierrickmonchoix.memoryserver.websocketServer.websocketMessage.WebsocketMessageDecoder;
import com.pierrickmonchoix.memoryserver.websocketServer.websocketMessage.WebsocketMessageEncoder;


/**
 * grace aux encodeurd/decoders, la classe recoit des json et renvoie des json automatiquement (avec andoird on doit le faire a la main a priori)
 */
@ServerEndpoint(value = "/websocket" , encoders = WebsocketMessageEncoder.class, decoders = WebsocketMessageDecoder.class)
public class WebsocketServerEndpoint {

	@OnOpen
	public void onOpen(Session session)
			throws IOException {
		System.out.println("ChatEndpoint.onOpen()");
	}

	@OnMessage
	public void onMessage(WebsocketMessage message, Session session) {

		System.out.println("### le server recoit : ");

        System.out.println(message);

        System.out.println("### le server recoit : ");
        message.setContenu("ce message a ete envoye par le server hey");
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
