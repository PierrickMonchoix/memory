package com.pierrickmonchoix.memoryclient.websocketClient;

import java.net.URI;

import javax.websocket.Session;

import com.pierrickmonchoix.memoryclient.websocketMessage.WebsocketMessage;

import org.glassfish.tyrus.client.ClientManager;



/**
 * @author Mickael BARON (baron.mickael@gmail.com)
 */
public class WebsocketClientLauncher {

	

	public static void main(String[] args) {

        WebsocketClient websocketClient = WebsocketClient.getInstance();
        websocketClient.connectToEndpoint();
        
        websocketClient.sendMessage();

        while(true){

        }
		/* try {
			ClientManager client = ClientManager.createClient();
			Session currentSession = client.connectToServer(new WebsocketClientEndpoint(),
					new URI("ws://localhost:8026/chatwebsocket/chat/mickaelbaron"));
            System.out.println("### le client envoie:  My First Message");
            WebsocketMessage message =  new WebsocketMessage();
            message.setContenu("yolo");
            message.setPseudo("bernado");
            message.setType(48);
			currentSession.getBasicRemote().sendObject(message);
			while(true){}

		} catch (Exception e) {
			e.printStackTrace();
		} */
	}
}
