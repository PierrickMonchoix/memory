package com.pierrickmonchoix.memoryclient.websocket.websocketClient;

import java.io.IOException;

import javax.websocket.ClientEndpoint;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

import com.pierrickmonchoix.memoryclient.websocket.WebsocketHelper;
import com.pierrickmonchoix.memoryclient.websocket.websocketMessage.WebsocketMessage;
import com.pierrickmonchoix.memoryclient.websocket.websocketMessage.WebsocketMessageDecoder;
import com.pierrickmonchoix.memoryclient.websocket.websocketMessage.WebsocketMessageEncoder;

/**
 * Décrit ce que doit faire le client websocket
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

        WebsocketHelper.notifyListenersOfMessage(message);

    }

    public WebsocketClient getClient() {
        return client;
    }

    public void setClient(WebsocketClient client) {
        this.client = client;
    }

}
