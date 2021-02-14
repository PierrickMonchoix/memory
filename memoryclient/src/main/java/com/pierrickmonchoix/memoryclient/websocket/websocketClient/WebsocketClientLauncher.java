package com.pierrickmonchoix.memoryclient.websocket.websocketClient;

/**
 * @author Mickael BARON (baron.mickael@gmail.com)
 */
public class WebsocketClientLauncher {

	

	public static void main(String[] args) {


        WebsocketClient websocketClient = WebsocketClient.getInstance();
        websocketClient.connectToEndpoint();
        

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
