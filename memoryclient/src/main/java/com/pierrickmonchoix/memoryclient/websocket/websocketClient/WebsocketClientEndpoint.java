package com.pierrickmonchoix.memoryclient.websocket.websocketClient;

import java.io.IOException;

import javax.websocket.ClientEndpoint;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

import com.pierrickmonchoix.memoryclient.websocket.websocketMessage.WebsocketMessage;
import com.pierrickmonchoix.memoryclient.websocket.websocketMessage.WebsocketMessageDecoder;
import com.pierrickmonchoix.memoryclient.websocket.websocketMessage.WebsocketMessageEncoder;

/**
 * @author Mickael BARON (baron.mickael@gmail.com)
 */
@ClientEndpoint(encoders = WebsocketMessageEncoder.class, decoders = WebsocketMessageDecoder.class)
public class WebsocketClientEndpoint {

    private WebsocketClient client;

    @OnOpen
    public void onOpen(Session session) throws IOException {
        System.out.println("ChatClientEndpoint.onOpen()");

    }

    @OnMessage
    public void onMessage(WebsocketMessage message) {
        System.out.println("Le clien recoit  : ");

        System.out.println("Received by client : " + message);

        if (client != null) {
            client.notifyListenersOfMessage(message);
        } else {
            System.out.println("Client NULL !!! on a oublié de le connecter a l'endpoint");
        }
    }

    public WebsocketClient getClient() {
        return client;
    }

    public void setClient(WebsocketClient client) {
        this.client = client;
    }

}
